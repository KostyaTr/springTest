package com.github.KostyaTr.springTest.annotation;

import com.github.KostyaTr.springTest.annotation.dao.AnnotationDao;
import com.github.KostyaTr.springTest.annotation.service.AnnotationService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnnotationTest {

    @Test
    void annotationTest(){
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.KostyaTr.springTest.annotation");
        context.refresh();

        final AnnotationService serviceBean = context.getBean(AnnotationService.class);
        final AnnotationDao daoBean = context.getBean(AnnotationDao.class);

        System.out.println(serviceBean);
        System.out.println(daoBean);

        assertEquals("I'm AnnotationDao", daoBean.getName());
        assertEquals("I'm AnnotationService and I'm AnnotationDao", serviceBean.getName());
    }
}