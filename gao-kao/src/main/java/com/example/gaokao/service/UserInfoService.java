package com.example.gaokao.service;

import com.example.gaokao.entity.Do.AuthUser;
import com.example.gaokao.entity.Do.Idea;
import com.example.gaokao.entity.Do.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoService {
    //根据用户名密码查询
    UserInfo selectByUserNameAndUserPwd(String userName, String userPwd,String userPhone,String userEmail);
    //用户注册
    int UserRegister(UserInfo userInfo);

    UserInfo selectByUserPhone(String userPhone);
    //查找是否认证
    String selectByAuthentication(UserInfo userInfo);
    //根据是否实名认证修改
    int updateAuthentication(UserInfo userInfo);
    //用户意见
    int insertContent(Idea idea);
    //用户认证信息存储
    int insertAuth(AuthUser authUser);
    AuthUser getUserByauthName(String name,String idCard);
}
