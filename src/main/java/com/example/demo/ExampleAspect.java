package com.example.demo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class ExampleAspect {

    @Before("execution(* com.example.demo.*.*(..))")
    public void beforeExampleMethod(JoinPoint joinPoint) {
        System.out.println("Before " + joinPoint.getSignature() +
                "\n args: " + Arrays.toString(joinPoint.getArgs()) +
                "\n target: " + joinPoint.getTarget() +
                "\n this: " + joinPoint.getThis() +
                "\n string: " + joinPoint.toString());
    }

    @Pointcut("args(String)")
    private void inExampleMethod() {
    }

    @AfterReturning(pointcut = "inExampleMethod()", returning = "retVal")
    public void afterReturningExampleMethod(Object retVal) {
        System.out.println("AfterReturning exampleMethod(), returned value: " + retVal.toString());
    }

    @Around("within(com.example.demo..*)")
    public Object aroundExampleMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around exampleMethod() before proceed()");
        Object ret = pjp.proceed();
        System.out.println("Around exampleMethod() after proceed()");
        return ret;
    }

    @Pointcut("target(com.example.demo.Example)")
    public void targetExample() {};

    @AfterThrowing(pointcut = "inExampleMethod()", throwing = "exception")
    public Object afterThrowingExampleMethod(Object exception) {
        System.out.println("AfterThrowing exampleMethod(), exception: " + exception.toString());
        return exception;
    }
}

