package com.xc.demo.think.seven.entity;

import org.junit.Test;

/**
 * @author changxu13
 * @date 2020-03-19 11:53
 */
public class demo1 {

    /**
     * 当编译器需要一个string而当前为一个对象时，会自动调用该对象的toString()方法
     */
    @Test
    public void test1() {
//        Person person = new Person();
//        person.setAge(18);
//        person.setName("小明");
//
//        System.out.println("Person ： " + person);
    }

    @Test
    public void test2() {
        Man man = new Man(18, "小明");
        System.out.println(man);
    }

    @Test
    public void test3() {
        Person person = new Person(18, "小明");
        Man man = new Man(18, "小明");
        System.out.println(man.doS());
    }
}
