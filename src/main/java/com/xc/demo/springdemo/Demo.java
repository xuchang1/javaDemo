package com.xc.demo.springdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Demo {

    @Test
    public void test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springdemo.xml");
//        Person person = (Person) context.getBean("person");

        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        System.out.println("---------------------");
//        for (String name : beanDefinitionNames) {
//            System.out.println(name);
//        }
        Object bean1 = context.getBean("com.xc.demo.springdemo.MyFactoryBean");
        Object bean2 = context.getBean("&com.xc.demo.springdemo.MyFactoryBean");
        System.out.println(bean1 instanceof Person);//true
        System.out.println(bean2 instanceof MyFactoryBean);//true
//        Object bean1 = context.getBean("com.xc.demo.springdem.MyFactoryBean");
    }
}
