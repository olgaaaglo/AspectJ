package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Example e = (Example) context.getBean("exampleBean");

        System.out.println("calling exampleMethod()...");
        e.exampleMethod("EXAMPLE");
        System.out.println("\n");
        try {
            e.exampleMethod("THROW");
        }
        catch (RuntimeException ex) {

        }
    }

}
