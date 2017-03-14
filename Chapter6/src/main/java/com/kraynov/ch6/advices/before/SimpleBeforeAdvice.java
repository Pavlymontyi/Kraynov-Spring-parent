package com.kraynov.ch6.advices.before;

import com.kraynov.ch6.hw.MessageWriter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method: "+method.getDeclaringClass() + "#" + method.getName()+"\n\n");
    }

    public static void main(String[] args){
        MessageWriter bean = new MessageWriter();

        ProxyFactory pf = new ProxyFactory(bean);
        pf.addAdvice(new SimpleBeforeAdvice());

        MessageWriter proxy = (MessageWriter) pf.getProxy();
        proxy.printMessage();

        System.out.println("\n");
    }
}
