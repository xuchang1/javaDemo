package com.xc.demo.springdemo.value;

import org.springframework.beans.factory.annotation.Value;

/**
 * 读取属性值@Value 注解
 *  1、直接读取值
 *  2、#{} SpEL表达式
 *  3、${} 读取环境变量中的值，通过@PropertySource指定需要读取的配置文件，会将配置文件中的数据读取为k、v的形式，保存到
 *          环境变量environment中，可以通过ApplicationContext获取environment后，直接拿到配置文件中的值
 */
public class Person {

    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private int age;

    @Value("${person.nickName}")
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
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
