package com.xc.demo.springdemo.lifecycle;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("person ... constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("person ... init");
    }

    public void destroy() {
        System.out.println("person ... destroy");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
