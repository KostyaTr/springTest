package com.github.KostyaTr.springTest.config;

public class UserServiceMultipleBeans {

    private UserDao userDao;

    public UserServiceMultipleBeans() {
    }

    public UserServiceMultipleBeans(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    String getUser(){
        return "I am UserServiceMultipleBeans and I'm : " + userDao.addUser();
    }
}
