package com.xc.demo.think.seven;

import com.xc.demo.think.seven.entity.Person;

/**
 * @author changxu13
 * @date 2020-03-19 11:57
 */
public class Man extends Person{

    private String sex = "男";

    public Man(int age, String name) {
        super(age, name);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String do2() {
        return doS();
    }

    @Override
    public String toString() {
        return "Man{" +
                "sex='" + sex + '\'' +
                '}';
    }
}