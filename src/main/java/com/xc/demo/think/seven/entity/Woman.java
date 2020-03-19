package com.xc.demo.think.seven.entity;

/**
 * @author changxu13
 * @date 2020-03-19 16:33
 */
public class Woman {

    private Person person = new Person(18, "小红");

    public String do1() {
        return person.doS();
    }
}
