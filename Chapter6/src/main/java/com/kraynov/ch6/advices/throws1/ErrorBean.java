package com.kraynov.ch6.advices.throws1;

public class ErrorBean {

    public void throwException() throws Exception{
        throw new Exception("Foo");
    }

    public void throwOtherException() throws NullPointerException{
        throw new NullPointerException("Bar");
    }
}
