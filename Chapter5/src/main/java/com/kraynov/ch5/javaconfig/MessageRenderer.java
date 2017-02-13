package com.kraynov.ch5.javaconfig;

public interface MessageRenderer {
    public void renderMessage();

    public void setMessageProvider(MessageProvider provider);

    public MessageProvider getMessageProvider();
}
