package com.kraynov.ch6.advices.before.security;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    SecurityManager sm;

    public SecurityAdvice(SecurityManager sm) {
        this.sm = sm;
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo currentUser = sm.getLoggedUser();
        if (currentUser == null){
            throw new SecurityException("You need to login to comment news on vk");
        } else if ("pavlymontyi".equals(currentUser.getLogin())){
            System.out.println("Pavlymontyi added comment");
        } else {
            throw new SecurityException("Only pavlymontyi can comment news on vk");
        }
    }

}
