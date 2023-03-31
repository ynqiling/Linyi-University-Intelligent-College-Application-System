package com.example.gaokao.service.impl;

import com.example.gaokao.dao.UserInfoDao;
import com.example.gaokao.entity.Do.AuthUser;
import com.example.gaokao.entity.Do.Idea;
import com.example.gaokao.service.UserInfoService;
import com.example.gaokao.entity.Do.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;
    @Override
    public UserInfo selectByUserNameAndUserPwd(String userName, String userPwd,String userPhone,String userEmail) {
        return userInfoDao.selectByUserNameAndUserPwd(userName, userPwd,userPhone,userEmail) ;
    }

    @Override
    public int UserRegister(UserInfo userInfo) {
        return userInfoDao.UserRegister(userInfo);
    }

    @Override
    public UserInfo selectByUserPhone(String userPhone) {
        return userInfoDao.selectByUserPhone(userPhone);
    }

    @Override
    public String selectByAuthentication(UserInfo userInfo) {
        return userInfoDao.selectByAuthentication(userInfo);
    }

    @Override
    public int updateAuthentication(UserInfo userInfo) {
        return userInfoDao.updateAuthentication(userInfo);
    }

    @Override
    public int insertContent(Idea idea) {
        return userInfoDao.insertContent(idea);
    }

    @Override
    public int insertAuth(AuthUser authUser) {
        return userInfoDao.insertAuth(authUser);
    }

    @Override
    public AuthUser getUserByauthName(String name,String idCard) {
        return userInfoDao.getUserByauthName(name,idCard);
    }


}
