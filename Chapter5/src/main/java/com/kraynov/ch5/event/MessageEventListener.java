package com.kraynov.ch5.event;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        System.out.println("Received: "+messageEvent.getMessage());
    }
}
