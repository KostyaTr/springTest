package com.github.KostyaTr.springTest.annotation.service;

import com.github.KostyaTr.springTest.annotation.dao.AnnotationDao;
import org.springframework.stereotype.Component;

@Component
public class AnnotationService {
    private AnnotationDao annotationDao;

    public AnnotationService(AnnotationDao annotationDao) {
        this.annotationDao = annotationDao;
    }

    public String getName(){
        return "I'm AnnotationService and " + annotationDao.getName();
    }
}
