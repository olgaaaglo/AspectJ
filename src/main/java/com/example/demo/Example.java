package com.example.demo;

public class Example {
    public boolean exampleMethod(String s) {
        System.out.println("In exampleMethod: " + s);
        if (s.equals("THROW")) {
            throw new RuntimeException();
        }
        return true;
    }
}
