package com.github.KostyaTr.springTest.config;

import com.github.KostyaTr.springTest.custom.annotation.Profiling;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigTest {

    @Test
    void configTestByField() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();

        UserServiceByField serviceByField = context.getBean(UserServiceByField.class);
        System.out.println(serviceByField.addUser());

        assertEquals("I am UserServiceByField have added new user: Hi, I Am New Default User",
                serviceByField.addUser());
    }

    @Test
    void configTestByConstr() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();

        UserServiceByConstr serviceByConstr = context.getBean(UserServiceByConstr.class);
        System.out.println(serviceByConstr.addUser());

        assertEquals("I am UserServiceByConstr have added new user: Hi, I Am New Default User",
                serviceByConstr.addUser());
    }

    @Test
    void configTestBySetter() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();

        UserServiceBySetter serviceBySetter = context.getBean(UserServiceBySetter.class);

        System.out.println(serviceBySetter.addUser());

        assertEquals("I am UserServiceBySetter have added new user: Hi, I Am New Default User",
                serviceBySetter.addUser());
    }

    @Test
    void twoBeansFromInterface() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();

        UserServiceInjectTwoBeans serviceInjectTwoBeans = context.getBean(UserServiceInjectTwoBeans.class);

        System.out.println(serviceInjectTwoBeans.addAdminUser());
        System.out.println(serviceInjectTwoBeans.addDefaultUser());

        assertEquals("I am UserServiceInjectTwoBeans have added new user: Hi, I Am New Default User",
                serviceInjectTwoBeans.addDefaultUser());

        assertEquals("I am UserServiceInjectTwoBeans have added new user: Hi! I'm an Admin User",
                serviceInjectTwoBeans.addAdminUser());
    }

    @Test
    void beans() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();

        UserServiceMultipleBeans serviceMultipleBeans = context.getBean(UserServiceMultipleBeans.class);
        DefaultUserDao defaultUserDao = context.getBean(DefaultUserDao.class);
        AdminUserDao adminUserDao = context.getBean(AdminUserDao.class);

        /*serviceMultipleBeans.setUserDao(defaultUserDao);
        System.out.println(serviceMultipleBeans.getUser());

        serviceMultipleBeans.setUserDao(adminUserDao);
        System.out.println(serviceMultipleBeans.getUser());*/
    }

    @Test
    void injectingUsingFile() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserServiceByFile.class);
        context.refresh();

        UserServiceByFile userServiceByFile = context.getBean(UserServiceByFile.class);
        final String userDaoName = userServiceByFile.getUserDaoName();

        final UserDao userDao = (UserDao) context.getBean(userDaoName);
        userServiceByFile.setUserDao(userDao);

        assertEquals("I am UserServiceByField have added new user: " + userDao.addUser(),
                userServiceByFile.addUser());
    }
}
