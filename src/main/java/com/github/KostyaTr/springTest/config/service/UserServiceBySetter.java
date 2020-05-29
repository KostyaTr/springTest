package com.github.KostyaTr.springTest.config.service;

import com.github.KostyaTr.springTest.config.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceBySetter {

    private UserDao userDao;

    @Autowired
    public void setUserDao(@Qualifier("DefaultUser") UserDao userDao) {
        this.userDao = userDao;
    }

    public String addUser(){
        return "I am UserServiceBySetter have added new user: " + userDao.addUser();
    }
}
