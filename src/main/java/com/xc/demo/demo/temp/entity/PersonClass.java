package com.xc.demo.demo.temp.entity;

import java.util.List;

public class PersonClass {

    /**
     * 班级id
     */
    private String id;

    /**
     * 班级
     */
    private String classes;

    /**
     * 学生
     */
    private List<Student> students;

    public PersonClass(String id, String classes, List<Student> students) {
        this.id = id;
        this.classes = classes;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
