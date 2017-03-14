package com.kraynov.ch6.advices.afterreturning;

import com.kraynov.ch6.hw.MessageWriter;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName()+" was finished. Return value: "+returnValue);
    }

    public static void main(String[] args){
        System.out.println("Simple 'After returning' advice example:");
        MessageWriter bean = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(bean);
        pf.addAdvice(new SimpleAfterReturningAdvice());

        MessageWriter proxy = (MessageWriter) pf.getProxy();
        proxy.printMessage();
        System.out.println("-------------------------------");
    }
}
