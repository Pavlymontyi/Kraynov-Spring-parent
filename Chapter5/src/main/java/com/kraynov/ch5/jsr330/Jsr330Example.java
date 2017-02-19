package com.kraynov.ch5.jsr330;

import com.kraynov.ch5.javaconfig.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr330Example {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:jsr330/app-config-jsr330.xml");
        ctx.refresh();
        MessageRenderer render = ctx.getBean("messageRenderer", MessageRenderer.class);
        render.renderMessage();
    }
}
