package com.github.KostyaTr.springTest.config.dao;

import com.github.KostyaTr.springTest.config.dao.AdminUserDao;
import com.github.KostyaTr.springTest.config.dao.DefaultUserDao;
import com.github.KostyaTr.springTest.config.dao.UserDao;
import com.github.KostyaTr.springTest.custom.annotation.Profiling;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaDaoConfig {

    @Profiling
    @Bean("DefaultUser")
    public UserDao defaultUserDao(){
        return new DefaultUserDao();
    }

    @Profiling
    @Bean("AdminUser")
    public UserDao adminUserDao(){
        return new AdminUserDao();
    }
}
