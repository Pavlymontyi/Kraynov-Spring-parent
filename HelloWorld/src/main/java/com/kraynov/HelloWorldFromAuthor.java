package com.kraynov;

public class HelloWorldFromAuthor extends HelloWorld{

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void printMessage(){
        System.out.println("Hello world message: " + getMessage() + " from "+getAuthor());
    }

}
