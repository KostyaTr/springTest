package com.github.KostyaTr.springTest.config;

public class AdminUserDao implements UserDao {
    @Override
    public String addUser() {
        return "Hi! I'm an Admin User";
    }
}
