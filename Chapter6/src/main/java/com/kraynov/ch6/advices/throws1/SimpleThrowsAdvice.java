package com.kraynov.ch6.advices.throws1;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice{

    public static void main(String args[]){
        ErrorBean bean = new ErrorBean();
        ProxyFactory pf = new ProxyFactory(bean);
        pf.addAdvice(new SimpleThrowsAdvice());
        bean = (ErrorBean) pf.getProxy();

        try{
            bean.throwException();
        } catch (Exception e){}

        try{
            bean.throwOtherException();
        } catch (Exception e){}
    }

    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target, NullPointerException ex) throws Throwable{
        System.out.println("***");
        System.out.println("NullPointerException Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("Method: " + method.getName()) ;
        System.out.println("***\n");
    }

}
