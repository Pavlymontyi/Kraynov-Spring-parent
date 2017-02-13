package com.kraynov.ch5.javaconfig;

public class StandartOutMessageRenderer implements MessageRenderer{

    MessageProvider messageProvider;

    @Override
    public void renderMessage() {
        if (messageProvider == null){
            throw new RuntimeException("You must set property 'messageProvider' of class: " +
                    StandartOutMessageRenderer.class.getName());
        }
        System.out.println("Rendered message: "+messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
