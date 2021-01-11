package com.xc.demo.springdemo;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        System.out.println("初始化bean");
        return new Person("小明");
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
