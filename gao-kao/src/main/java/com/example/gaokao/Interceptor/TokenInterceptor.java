package com.example.gaokao.Interceptor;

import com.example.gaokao.utils.Result;
import com.example.gaokao.entity.Do.UserInfo;
import com.example.gaokao.utils.ResultCodeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
token过滤器
* */

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
       Result<Object> result=new Result<>();
    // 请求之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拿到header中的token
        String token = request.getHeader("token");
        //用户未登录
        if(token==null){
           result=Result.build(null,ResultCodeEnum.LOGIN_AUTH);
            // 将返回消息体转化为json
            String json = new ObjectMapper().writeValueAsString(result);
            // 设置编码类型
            response.setContentType("application/json;charset=UTF-8");
            // 放入响应中
            response.getWriter().println(json);
            return false;

        }

            UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(token);
            if (userInfo != null) {
                return true;
            }
            else {
                result = Result.build(null, ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
                // 将返回消息体转化为json
                String json = new ObjectMapper().writeValueAsString(result);

                // 设置编码类型
                response.setContentType("application/json;charset=UTF-8");
                // 放入响应中
                response.getWriter().println(json);
                return false;

            }
        }






    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
