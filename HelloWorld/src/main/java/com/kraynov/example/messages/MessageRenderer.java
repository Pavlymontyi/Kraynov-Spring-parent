package com.kraynov.example.messages;

public interface MessageRenderer {

    public void render();

    public void setMessageProvider(MessageProvider messageProvider);

    public MessageProvider getMessageProvider();
}
