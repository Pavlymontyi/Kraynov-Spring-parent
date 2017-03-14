package com.kraynov.ch6.advices.before.security;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {

    public static void main(String[] args){
        SecurityManager manager = new SecurityManager();

        SecureBean sbean = new SecureBean();
        ProxyFactory pf = new ProxyFactory(sbean);
        pf.addAdvice(new SecurityAdvice(manager));
        SecureBean proxy = (SecureBean) pf.getProxy();

        manager.login("pavlymontyi", "123");
        proxy.doSomethingSecure();
        manager.logout();

        try{
            manager.login("kolya", "123");
            proxy.doSomethingSecure();
        } catch (SecurityException ex){
            System.out.println("Exception was caught: "+ex.getMessage());
        } finally {
            manager.logout();
        }

        try{
            proxy.doSomethingSecure();
        } catch (SecurityException ex){
            System.out.println("Exception was caught: "+ex.getMessage());
        } finally {
            manager.logout();
        }

        System.out.println("-------------------------------");
    }

}
