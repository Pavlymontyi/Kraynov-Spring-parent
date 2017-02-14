package com.kraynov.ch5.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //применяется к типу, сообщает платформе Spring о том, что это конфигурационный файл, основанный на java.
public class AppConfig {

    //XML:
    //<bean id="messageProvider" class="com.kraynov.ch5.javaconfig.ConfigurableMessageProvider"/>
    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    //XML
    // <bean id="messageRenderer" class="com.kraynov.ch5.javaconfig.StandartOutMessageRenderer">
    //     <property name="messageProvider" ref="messageProvider"/>
    // </bean>
    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer render = new StandartOutMessageRenderer();
        //внедрение через сеттер
        render.setMessageProvider(messageProvider());
        return render;
    }
}
