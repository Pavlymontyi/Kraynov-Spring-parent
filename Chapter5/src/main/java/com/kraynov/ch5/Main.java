package com.kraynov.ch5;

import com.kraynov.ch5.env.EnvironmentSample;
import com.kraynov.ch5.env.PlaceHolderSample;
import com.kraynov.ch5.event.Publisher;
import com.kraynov.ch5.javaconfig.JavaConfigSimpleExample;
import com.kraynov.ch5.jsr330.Jsr330Example;
import com.kraynov.ch5.profile.ProfileXMLConfigExample;
import com.kraynov.ch5.propeditors.CustomEditorExample;
import com.kraynov.ch5.propeditors.PropertyEditorBean;
import com.kraynov.ch5.resource.ResourceDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        System.out.println("\n\nChapter 5 is running\n\n");

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

        //Доступ к ресурсам
        ResourceDemo.main(null);

        //Конфигурирование ApplicationContext в Java-классе
        JavaConfigSimpleExample.main(null);

        //Профили
        ProfileXMLConfigExample.main(null);

        //Работа с абстракциями Environment и PropertySources
        EnvironmentSample.main(null);
        PlaceHolderSample.main(null);

        //JSR330 - DI in JEE6
        Jsr330Example.main(null);
    }


}
