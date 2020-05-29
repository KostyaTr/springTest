package com.github.KostyaTr.springTest.config.service;

import com.github.KostyaTr.springTest.config.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceByField {

    @Autowired
    @Qualifier("DefaultUser")
    private UserDao userDao;

    public String addUser(){
        return "I am UserServiceByField have added new user: " + userDao.addUser();
    }
}
