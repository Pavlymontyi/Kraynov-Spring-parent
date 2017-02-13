package com.kraynov.ch5.event;

import org.springframework.context.ApplicationListener;

public class MessageEventChildListener implements ApplicationListener<MessageEventChild> {

    @Override
    public void onApplicationEvent(MessageEventChild messageEvent) {
        System.out.println("CHILD received: "+messageEvent.getMessage());
    }
}
