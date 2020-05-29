package com.github.KostyaTr.springTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceInjectTwoBeans {

    @Autowired
    @Qualifier("AdminUser")
    private UserDao adminUserDao;

    @Autowired
    @Qualifier("DefaultUser")
    private UserDao defaultUserDao;

    String addDefaultUser(){
        return "I am UserServiceInjectTwoBeans have added new user: " + defaultUserDao.addUser();
    }

    String addAdminUser(){
        return "I am UserServiceInjectTwoBeans have added new user: " + adminUserDao.addUser();
    }
}
