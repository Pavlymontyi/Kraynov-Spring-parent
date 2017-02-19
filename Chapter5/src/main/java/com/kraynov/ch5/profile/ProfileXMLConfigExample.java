package com.kraynov.ch5.profile;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXMLConfigExample {

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("highschool");
        ctx.load("classpath:profile/*-config.xml");
        ctx.refresh();

        FoodProviderService foodProvider = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProvider.provideLunchSet();

        for(Food food : lunchSet){
            System.out.println(food.getName());
        }
    }
}
