package com.kraynov.ch6.declar.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.kraynov.ch6.declar..foo*(int)) && args(intValue)")
    public void fooExecution(int intValue){}

    @Pointcut("bean(myDependency*)")
    public void inMyDependency(){}

    @Before("fooExecution(intValue) && inMyDependency()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue){
        if (intValue != 100) {//выполнять только если intValue != 100
            System.out.println("Execution: " + joinPoint.getSignature().getDeclaringTypeName() + " " +
                    joinPoint.getSignature().getName() + " argument: " + intValue);
        }
    }

    @Around("fooExecution(intValue)")
    public Object simpleArountAdvice(ProceedingJoinPoint pjp, int intValue) throws Throwable{
        //вывести информацию перед выполнением
        System.out.println("Before execution: " + pjp.getSignature().getDeclaringTypeName() + " " +
                pjp.getSignature().getName() + " argument: " + intValue);

        Object retVal = pjp.proceed();

        System.out.println("After execution: " + pjp.getSignature().getDeclaringTypeName() + " " +
                pjp.getSignature().getName() + " argument: " + intValue);

        return retVal;
    }
}
