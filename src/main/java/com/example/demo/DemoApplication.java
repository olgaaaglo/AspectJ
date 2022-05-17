package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		//new Example().exampleMethod();

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        //AspectLogger  obj = (AspectLogger) context.getBean("aspectLogger");
//        //System.out.println( obj.getServiceName() );
//        new Example().exampleMethod();

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Example e = (Example) context.getBean("exampleBean");
        System.out.println("calling exampleMethod()...");
        e.exampleMethod();
    }

}
