package com.github.KostyaTr.springTest.config.service;

import com.github.KostyaTr.springTest.config.dao.UserDao;

public class UserServiceByConstr {

    private UserDao userDao;

    public UserServiceByConstr(UserDao userDao) {
        this.userDao = userDao;
    }

    public String addUser(){
        return "I am UserServiceByConstr have added new user: " + userDao.addUser();
    }
}
