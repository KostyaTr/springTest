package com.github.KostyaTr.springTest.config;

public class UserServiceByConstr {

    private UserDao userDao;

    public UserServiceByConstr(UserDao userDao) {
        this.userDao = userDao;
    }

    String addUser(){
        return "I am UserServiceByConstr have added new user: " + userDao.addUser();
    }
}
