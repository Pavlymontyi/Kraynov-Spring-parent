package com.kraynov.example.messages;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
        System.out.printf("MessageRenderer.messageProvider bean: %s\n",
                messageRenderer.getMessageProvider().toString());

        MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
        System.out.printf("Test annotation way for messageProvider: %s\n", messageProvider.getMessage());
        System.out.printf("messageProvider bean: %s\n",
                messageProvider.toString());
    }
}
