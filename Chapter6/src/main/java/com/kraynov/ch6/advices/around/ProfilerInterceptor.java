package com.kraynov.ch6.advices.around;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;

public class ProfilerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        sw.stop();
        dumpInfo(methodInvocation, sw.getTotalTimeMillis());
        return result;
    }

    private void dumpInfo(MethodInvocation methodInvocation, long totalTimeMillis) {
        Method m = methodInvocation.getMethod();
        Object target = methodInvocation.getThis();
        Object args[] = methodInvocation.getArguments();
        System.out.println("Executed method: " + m.getName());
        System.out.println("On object of type: " + this.getClass().getName());
        System.out.println("With arguments: " + Arrays.asList(args));
        System.out.println("Took: " + totalTimeMillis+" ms");
    }

    public static void main(String[] args){
        System.out.println("Simple 'around' advice example:");
        WorkerBean bean = new WorkerBean();

        ProxyFactory pf = new ProxyFactory(bean);
        pf.addAdvice(new ProfilerInterceptor());
        bean = (WorkerBean) pf.getProxy();
        bean.doWork(100000);
        System.out.println("-------------------------------");
    }
}

class WorkerBean{

    public void doWork(long count){
        int a=13, b=54;
        for (long i=0;i<count; i++){
            a = a*b>>2;
        }
    }
}
