package com.kraynov.ch5.jsr330;

import com.kraynov.ch5.javaconfig.MessageProvider;

import javax.inject.Inject;
import javax.inject.Named;

@Named("messageProvider")
public class ConfiguraЬleMessageProvider implements MessageProvider {

    private String message = "Default message";

    @Inject
    @Named("message")
    public ConfiguraЬleMessageProvider(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
