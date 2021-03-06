package com.github.KostyaTr.springTest.config.service;

import com.github.KostyaTr.springTest.config.dao.JavaDaoConfig;
import com.github.KostyaTr.springTest.config.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import(JavaDaoConfig.class)
@PropertySource("classpath:res.properties")
public class UserServiceByFile {

    @Value("${userDaoName}")
    private String userDaoName;

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUserDaoName() {
        return userDaoName;
    }

    public String addUser(){
        return "I am UserServiceByField have added new user: " + userDao.addUser();
    }

    @Bean
    private static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
