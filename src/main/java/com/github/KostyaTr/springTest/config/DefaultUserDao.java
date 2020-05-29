package com.github.KostyaTr.springTest.config;

public class DefaultUserDao implements UserDao {
    @Override
    public String addUser() {
        return "Hi, I Am New Default User";
    }
}
