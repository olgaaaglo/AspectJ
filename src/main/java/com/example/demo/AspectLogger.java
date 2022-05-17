package com.example.demo;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
//@Component
public class AspectLogger {

    @Before("execution(* com.example.demo.Example.exampleMethod(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(" *** Advice Before - (logBefore) jest wykonany !");
        System.out.println(" *** Metoda : " + joinPoint.getSignature().getName()
                + "() rozpoczyna się od " + Arrays.toString(joinPoint.getArgs()));
    }



    @Pointcut("execution(* com.example.demo.*.*(..))")
    private void exampleMethod() {
    }

    @AfterReturning(pointcut = "exampleMethod()", returning = "retVal")
    public void afterReturningMethod(JoinPoint joinPoint, Object retVal) {
        System.out.println(" *** Advice AfterReturning - (afterReturningMethod) jest wykonany !");
        System.out.println(" *** Metoda " + joinPoint.getSignature().getName() + " zwróciła wartość : " );//+ retVal.toString()); -> null
    }



    @Around("execution(* com.example.demo.Example.exampleMethod(..))")
    public Object aroundExampleMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(" *** Advice Around - (beforeListPerson) jest wykonawany !");;
        Object[] args = pjp.getArgs();
        if(args.length>0){
            System.out.print(" *** Dopasowane argumenty : " );
            for (int i = 0; i < args.length; i++) {
                System.out.print("arg "+(i+1)+": "+args[i].toString());
            }
        }

        Example result = (Example) pjp.proceed(args);
        System.out.println(" *** Zwrócona wartość : " + result);
        return result;
    }

    @Pointcut("target(com.example.demo.Example)")
    public void exampleMethod2() {};

    @Around("exampleMethod2()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        System.out.print(" *** Czas wykonania " + methodName + " wynosi " +
                TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return retval;
    }


}

