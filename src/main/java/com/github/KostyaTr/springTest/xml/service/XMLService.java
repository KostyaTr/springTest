package com.github.KostyaTr.springTest.xml.service;

import com.github.KostyaTr.springTest.xml.dao.XMLDao;

public class XMLService {
    private XMLDao xmlDao;

    public XMLService(XMLDao xmlDao){
        this.xmlDao = xmlDao;
    }

    public String getName(){
       return "I am XMLService and " + xmlDao.getName();
    }
}
