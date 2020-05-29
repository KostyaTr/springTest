package com.github.KostyaTr.springTest.config.service;

import com.github.KostyaTr.springTest.config.dao.DefaultUserDao;
import com.github.KostyaTr.springTest.config.dao.JavaDaoConfig;
import com.github.KostyaTr.springTest.config.service.UserServiceByConstr;
import com.github.KostyaTr.springTest.config.service.UserServiceByField;
import com.github.KostyaTr.springTest.config.service.UserServiceBySetter;
import com.github.KostyaTr.springTest.config.service.UserServiceInjectTwoBeans;
import com.github.KostyaTr.springTest.custom.processor.ProfilingProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JavaDaoConfig.class)
public class JavaConfig {

    @Bean("UserServiceByField")
    public UserServiceByField userServiceByField() {
        return new UserServiceByField();
    }

    @Bean("UserServiceByConstr")
    public UserServiceByConstr userServiceByConstr() {
        return new UserServiceByConstr(new DefaultUserDao());
    }

    @Bean("UserServiceBySetter")
    public UserServiceBySetter userServiceBySetter() {
        return new UserServiceBySetter();
    }

    @Bean("UserServiceInjectTwoBeans")
    public UserServiceInjectTwoBeans userServiceWithAdminDao() {
        return new UserServiceInjectTwoBeans();
    }

    @Bean("CustomProfilingProcessor")
    private static ProfilingProcessor profilingProcessor() {
        return new ProfilingProcessor();
    }
}
