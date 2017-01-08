package com.kraynov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

        HelloWorldFromAuthor pakr = context.getBean("helloWorldFromPakr", HelloWorldFromAuthor.class);
        System.out.println("Spring test: Looks good");
        obj.printMessage();
        pakr.printMessage();
    }
}
