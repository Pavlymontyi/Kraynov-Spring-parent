package com.kraynov.ch6.declar;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanExample {

    public  static void main(String[] args){
        System.out.println("\n**************************");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:app-context-xml.xml");
        //ctx.refresh();
        МуВеаn myBean1 = (МуВеаn) ctx.getBean("myBean1");
        МуВеаn myBean2 = (МуВеаn) ctx.getBean("myBean2");
        System.out.println("Bean 1");
        myBean1.execute();
        System.out.println("\nBean 2");
        myBean2.execute();
    }
}
