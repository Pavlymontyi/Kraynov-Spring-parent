package com.kraynov.ch5.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JavaConfigSimpleExample {

    public static void main(String[] args){
        ApplicationContext ctx = new GenericXmlApplicationContext("javaconfig/javaconfig.xml");
        MessageRenderer render = (MessageRenderer) ctx.getBean("messageRenderer");
        render.renderMessage();

        ApplicationContext javaCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRenderer javaRender = (MessageRenderer) javaCtx.getBean("messageRenderer");
        javaRender.renderMessage();
    }
}
