package com.github.KostyaTr.springTest.xml;

import com.github.KostyaTr.springTest.xml.dao.XMLDao;
import com.github.KostyaTr.springTest.xml.service.XMLService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLTest {
    @Test
    void xmlTest(){
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        final XMLService serviceBean = context.getBean(XMLService.class);
        final XMLDao daoBean = context.getBean(XMLDao.class);

        System.out.println(daoBean.getName());
        System.out.println(serviceBean.getName());

        assertEquals("I'm XMLDao", daoBean.getName());
        assertEquals("I am XMLService and I'm XMLDao", serviceBean.getName());
    }
}
