package com.kraynov.ch5.env;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentSample {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        Map appMap = new HashMap<>();
        appMap.put("application.home", "etc/prospring3/home");
        propertySources.addLast(new MapPropertySource("PROSPRING3_MAP", appMap));
        System.out.println("user.home: "+System.getProperty("user.home"));
        System.out.println("JAVA_HOME: "+System.getProperty("JAVA_HOME"));
        System.out.println("user.home: "+env.getProperty("user.home"));
        System.out.println("JAVA_HOME: "+env.getProperty("JAVA_HOME"));
        System.out.println("JAVA_HOME: "+env.getProperty("application.home"));
    }
}
