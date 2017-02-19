package com.kraynov.ch5.env;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceHolderSample {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:env/env.xml");
        ctx.refresh();
        AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
        System.out.println(appProperty.getApplicationHome());
        System.out.println(appProperty.getUserHome());
    }
}
