package com.github.KostyaTr.springTest.config.dao;

public class AdminUserDao implements UserDao {
    @Override
    public String addUser() {
        return "Hi! I'm an Admin User";
    }
}
