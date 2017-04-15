package com.kraynov.ch6.declar.aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {

    public static void main (String [] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:appconfig-annotation.xml");
        ctx.refresh();
        МуВеаn myBean = (МуВеаn) ctx.getBean("myBean");
        myBean.execute();
    }
}
