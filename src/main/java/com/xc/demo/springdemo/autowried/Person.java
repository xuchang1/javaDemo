package com.xc.demo.springdemo.autowried;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import javax.inject.Inject;

public class Person {

//    @Qualifier("man3")
//    @Autowired(required = false)
    @Inject
    private Man man;

    private String name;

    private int age;

    private String nickName;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "man=" + man +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
