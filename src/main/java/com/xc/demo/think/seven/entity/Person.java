package com.xc.demo.think.seven.entity;

/**
 * @author changxu13
 * @date 2020-03-19 11:54
 */
public class Person {

    private int age;

    private String name;

    protected String sex = "男";

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String doS() {
        return "1111";
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
