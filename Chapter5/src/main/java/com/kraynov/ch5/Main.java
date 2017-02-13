package com.kraynov.ch5;

import com.kraynov.ch5.event.Publisher;
import com.kraynov.ch5.propeditors.CustomEditorExample;
import com.kraynov.ch5.propeditors.PropertyEditorBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        System.out.println("\n\nChapter 5 is running");

        //встроенные редакторы свойств
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:propeditors/builtin.xml");
        ctx.refresh();
        PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("builtInSample");

        //кастомные редакторы свойств
        GenericXmlApplicationContext ctx2 = new GenericXmlApplicationContext("propeditors/custom.xml");
        CustomEditorExample beanExample = (CustomEditorExample) ctx2.getBean("exampleBean");
        System.out.println(beanExample.getName());

        //Интернационализация с помощью интерфейса MessageSource
        //MessageSourceDemo.main(null);

        //MessageEvents
        ApplicationContext ctx3 = new GenericXmlApplicationContext("classpath:events/events.xml");
        Publisher pub = (Publisher) ctx3.getBean("publisher");
        pub.publish("Hello from publishing bean");
        pub.publishChild("Bla-bla");
    }
}
