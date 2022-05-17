//package com.example.demo;
//
//import com.example.demo.AspectLogger;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import java.util.Arrays;
//
////@Aspect
//@Configuration
////@ComponentScan("com.example.demo")
//@EnableAspectJAutoProxy(proxyTargetClass=true)
//public class AppConfig {
//
////    @Autowired
////    Example example;
////
////    @Bean(name="aspectLogger")
////    public AspectLogger aspectLogger() {
////        return new AspectLogger();
////    }
////
////    @Bean
////    public Example example() {
////        return new Example();
////    }
////
////    @Before("execution(public * *(..))") //execution(* com.example.demo.Example.exampleMethod(..))")
////    public void logBefore(JoinPoint joinPoint) {
////        System.out.println(" *** Advice Before - (logBefore) jest wykonany !");
////        System.out.println(" *** Metoda : " + joinPoint.getSignature().getName()
////                + "() rozpoczyna się od " + Arrays.toString(joinPoint.getArgs()));
////    }
//
//}
