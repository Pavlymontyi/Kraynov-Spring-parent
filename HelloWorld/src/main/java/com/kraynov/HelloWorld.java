package com.kraynov;

public class HelloWorld {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage(){
        System.out.println("Message: " + message);
    }
}