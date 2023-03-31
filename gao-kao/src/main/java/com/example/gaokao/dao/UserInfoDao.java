package com.example.gaokao.dao;

import com.example.gaokao.entity.Do.Auth;
import com.example.gaokao.entity.Do.AuthUser;
import com.example.gaokao.entity.Do.UserInfo;
import com.example.gaokao.entity.Do.Idea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao {

    UserInfo selectByPrimaryKey(Integer id);
    //根据用户名密码查询
    UserInfo selectByUserNameAndUserPwd(@Param("userName") String userName, @Param("userPwd") String userPwd, @Param("userPhone") String userPhone, @Param("userEmail") String userEmail);
    //用户注册
    int UserRegister(UserInfo userInfo);
    ////判断电话号码是否已经注册.
    UserInfo selectByUserPhone(String userPhone);
    //根据是否实名认证修改
    int updateAuthentication(@Param("userInfo") UserInfo userInfo);
    //查找是否认证
    String selectByAuthentication(@Param(("userInfo")) UserInfo userInfo);
    //用户意见
    int insertContent(@Param("idea") Idea idea);
    //用户认证信息存储
    int insertAuth(@Param("auth")AuthUser authUser);
    //根据name查找用户是否已经认证
    AuthUser getUserByauthName(String name,String idCard);


}