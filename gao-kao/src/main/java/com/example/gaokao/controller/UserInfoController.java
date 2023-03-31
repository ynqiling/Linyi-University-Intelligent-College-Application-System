package com.example.gaokao.controller;

import com.example.gaokao.config.RequestGet;
import com.example.gaokao.entity.Do.Auth;
import com.example.gaokao.entity.Do.AuthUser;
import com.example.gaokao.entity.Do.Idea;
import com.example.gaokao.entity.Do.UserInfo;
import com.example.gaokao.service.UserInfoService;
import com.example.gaokao.utils.JWTUtils;
import com.example.gaokao.utils.Result;
import com.example.gaokao.utils.ResultCodeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/*

 * */
@CrossOrigin
@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @PostMapping("/user/login")
    public Result login(HttpServletRequest request, @RequestBody UserInfo userInfo) {
        String userName = userInfo.getUserName();
        String userPwd = userInfo.getUserPwd();
        String userPhone = userInfo.getUserName();
        String userEmail = userInfo.getUserName();
        UserInfo user = new UserInfo();
        user = userInfoService.selectByUserNameAndUserPwd(userName, userPwd, userPhone, userEmail);
        if (user == null) {
            return Result.fail("无用户数据,或用户密码不正确");
            //  return Result.build(null, ResultCodeEnum.NONE_USER_MESSAGE);
        } else {
            //生成token
            String token = JWTUtils.createToken(user.getId(), user.getUserName());
            //存到redis中,key=token value=user
            redisTemplate.opsForValue().set(token, user);
            return getMapResult(user, token);
        }
    }

    /*
    用户注册
    * */
    @RequestMapping("/user/register")
    public Result UserRegister(@RequestBody UserInfo userInfo) {
        String userPhone = userInfo.getUserPhone();
        //打印电话号码
        System.out.println(userPhone);
        //判断电话号码是否合法.
        if (userPhone.length() != 11) {
            return Result.build(null, ResultCodeEnum.PHONE_NUMBER_ILLEGAL);
        }

        //判断电话号码是否已经注册.
        UserInfo ExistsUser = userInfoService.selectByUserPhone(userPhone);
        if (ExistsUser != null) {
            return Result.build(null, ResultCodeEnum.PHONE_NUMBER_EXIST);
            //
        } else {

            int i = userInfoService.UserRegister(userInfo);
            if (i == 1) {
                return getMapResult(userInfo, null);
            } else {
                return Result.build(null, ResultCodeEnum.FAIL_REGISTER_USER);
            }
        }


    }

    //实名认证
    @RequestMapping("/user/authuser")
    public Result realName(@RequestBody AuthUser authUser, HttpServletRequest request) throws JsonProcessingException {
        //判断身份证号是否合法.
        if (authUser.getIdCard().length() != 18) {
            return Result.build(null, ResultCodeEnum.ID_CARD_ILLEGAL);
        }
        //其次需要根据用户的输入查看数据库中有没有被认证过
        AuthUser userByauthName = userInfoService.getUserByauthName(authUser.getName(), authUser.getIdCard());
        if(userByauthName!=null){
            //说明已经认证
            return Result.fail().message("该身份信息已经被认证过");
        }
        //拿到请求头中的token

        String token = request.getHeader("token");
        //根据token拿到用户信息
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(token);
        //输出userInfo
        System.out.println(userInfo);
        //判断这个账号是否以及认证
        String authentication = userInfoService.selectByAuthentication(userInfo);
        if (authentication.equals("已认证")) {
            return Result.fail("该用户已认证");
        } else {
            //请正确填写appcode,如果填写错误阿里云会返回错误
            //appcode查看地址 https://market.console.aliyun.com/imageconsole/
            String appcode = "5b994bd421784700be175cc892f5dba6";
            //请求地址
            String url = "https://idcert.market.alicloudapi.com/idcard";
            //需要请求的内容
            String param = "idCard=" + authUser.getIdCard() + "&name=" + authUser.getName();
            //执行请求
            String returnStr = RequestGet.requestGet(url, param, appcode);
            // JSONObject jsonObject=returnStr.parse(User.class);
            //String专为对象类型
            ObjectMapper objectMapper = new ObjectMapper();
            Auth user = objectMapper.readValue(returnStr, Auth.class);
            if (user.getStatus().equals("01")) {//说明认证成功
                userInfo.setRealName(user.getName());
                userInfo.setRealIdCard(user.getIdCard());            //更新数据库中的用户信息
                userInfoService.updateAuthentication(userInfo);
                //把认证信息存入到数据库中
                userInfoService.insertAuth(authUser);

                //更新redis中的用户信息
                redisTemplate.opsForValue().set(token, userInfo);
                return Result.build(userInfo, ResultCodeEnum.REAL_NAME_SUCCESS);

            } else {
                return Result.build(null, ResultCodeEnum.REAL_NAME_FAIL);
            }
        }
    }
    @PostMapping("/user/addContent")
    public Result addContent(@RequestBody Idea idea){
        int i = userInfoService.insertContent(idea);
        if(i!=0){
            return Result.build(null,ResultCodeEnum.SUCCESS);
        }
        else{
            return Result.build(null, ResultCodeEnum.FAIL);
        }
    }
//    /*
//    测试登录后
//    * */
//    @RequestMapping("/test")
//    public String test(){
//        return "你好";
//
//    }
    //返回map信息类

    private Result<Map<String, Object>> getMapResult(UserInfo userInfo, String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", token);
        map.put("userMsg", userInfo);
        return Result.ok(map);
    }

    //阿里云认证
    public static String requestGet(String strUrl, String param, String appcode) {

        String returnStr = null; // 返回结果定义
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        try {
            url = new URL(strUrl + "?" + param);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET"); // get方式
            httpURLConnection.setUseCaches(false); // 不用缓存
            httpURLConnection.connect();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            reader.close();
            returnStr = buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return returnStr;
    }

}