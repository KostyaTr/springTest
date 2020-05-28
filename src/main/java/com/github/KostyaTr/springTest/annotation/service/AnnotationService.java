package com.github.KostyaTr.springTest.annotation.service;

import com.github.KostyaTr.springTest.annotation.dao.AnnotationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotationService {
    private AnnotationDao annotationDao;

    @Autowired
    public AnnotationService(AnnotationDao annotationDao) {
        this.annotationDao = annotationDao;
    }

    public String getName(){
        return "I'm AnnotationService and " + annotationDao.getName();
    }
}
