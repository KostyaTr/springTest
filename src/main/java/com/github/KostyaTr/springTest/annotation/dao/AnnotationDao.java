package com.github.KostyaTr.springTest.annotation.dao;

import org.springframework.stereotype.Component;

@Component
public class AnnotationDao {
    public String getName(){
        return "I'm AnnotationDao";
    }
}
