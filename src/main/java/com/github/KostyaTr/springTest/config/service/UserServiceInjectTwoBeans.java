package com.github.KostyaTr.springTest.config.service;

import com.github.KostyaTr.springTest.config.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceInjectTwoBeans {

    @Autowired
    @Qualifier("AdminUser")
    private UserDao adminUserDao;

    @Autowired
    @Qualifier("DefaultUser")
    private UserDao defaultUserDao;

    public String addDefaultUser(){
        return "I am UserServiceInjectTwoBeans have added new user: " + defaultUserDao.addUser();
    }

    public String addAdminUser(){
        return "I am UserServiceInjectTwoBeans have added new user: " + adminUserDao.addUser();
    }
}
