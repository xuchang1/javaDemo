package com.xc.demo.springdemo.autowried;

import org.springframework.stereotype.Component;

@Component("man3")
public class Man {

    private String name = "1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }
}
