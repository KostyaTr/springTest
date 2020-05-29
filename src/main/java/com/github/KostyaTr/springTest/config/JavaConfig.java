package com.github.KostyaTr.springTest.config;

import com.github.KostyaTr.springTest.custom.annotation.Profiling;
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

    @Bean("UserServiceMultipleBeans")
    public UserServiceMultipleBeans userServiceMultipleBeans() {
        return new UserServiceMultipleBeans();
    }

    @Bean("CustomProfilingProcessor")
    private static ProfilingProcessor profilingProcessor() {
        return new ProfilingProcessor();
    }
}
