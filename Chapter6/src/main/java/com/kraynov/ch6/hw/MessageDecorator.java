package com.kraynov.ch6.hw;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello ");
        Object result = methodInvocation.proceed();
        System.out.println("!!! Result is "+result);
        return result;
    }
}
