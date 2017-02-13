package com.kraynov.ch5.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceDemo {

    public static void main(String[] args){
        ApplicationContext resourceCtx = new GenericXmlApplicationContext("classpath:events/events.xml");

        Resource res1 = resourceCtx.getResource("file:///d:/test.txt");
        Resource res2 = resourceCtx.getResource("classpath:test.txt");
        Resource res3 = resourceCtx.getResource("http://www.google.co.uk");
        displayInfo(res1);
        displayInfo(res2);
        displayInfo(res3);
    }

    private static void displayInfo(Resource res) {
        try {
            System.out.println(res.getClass());
            System.out.println(res.getURL().getContent());
            System.out.println("");
        } catch (Exception e){
            System.out.println("Error during displayInfo: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
