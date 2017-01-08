package com.kraynov.example.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandartOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider = null;

    @Override
    public void render() {
        if (messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class: "
                    + StandartOutMessageRenderer.class.getName());
        }
        System.out.printf("%s\n", messageProvider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
