package com.xc.demo.demo.temp.entity;

public class Student {

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生分组
     */
    private String group;

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
