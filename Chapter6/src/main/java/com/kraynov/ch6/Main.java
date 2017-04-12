package com.kraynov.ch6;

import com.kraynov.ch6.advices.afterreturning.SimpleAfterReturningAdvice;
import com.kraynov.ch6.advices.around.ProfilerInterceptor;
import com.kraynov.ch6.advices.before.SimpleBeforeAdvice;
import com.kraynov.ch6.advices.before.security.SecurityExample;
import com.kraynov.ch6.advices.throws1.SimpleThrowsAdvice;
import com.kraynov.ch6.hw.HelloWorldAOPExample;
import com.kraynov.ch6.introductions.IntroductionExample;

public class Main {

    public static void main(String[] args){
        //Простейший пример использования AOP - декорирование вокруг
        HelloWorldAOPExample.main(args);

        //Создание и использование совета 'before'
        SimpleBeforeAdvice.main(args);
        //Совет 'перед'. Более сложный пример - Security Proxy
        SecurityExample.main(args);

        //Создание и использование совета 'after returning'
        SimpleAfterReturningAdvice.main(args);

        //Создание и использование совета 'around'
        ProfilerInterceptor.main(args);

        //Создание и использование совета 'throws'
        SimpleThrowsAdvice.main(args);

        //Пример, демонстрирующий работы с введениями
        IntroductionExample.main(args);
    }
}
