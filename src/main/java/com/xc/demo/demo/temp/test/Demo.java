package com.xc.demo.demo.temp.test;

import com.xc.demo.demo.temp.entity.PersonClass;
import com.xc.demo.demo.temp.entity.Student;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("小明", "一组"));
        list1.add(new Student("小红", "一组"));
        list1.add(new Student("小蓝", "二组"));
        PersonClass personClass1 = new PersonClass("1", "一班", list1);

        List<Student> list2 = new ArrayList<>();
        list1.add(new Student("小白", "一组"));
        list1.add(new Student("小绿", "二组"));
        list1.add(new Student("小紫", "二组"));
        PersonClass personClass2 = new PersonClass("2", "二班", list1);

        List<PersonClass> list = new ArrayList<>();
        list.add(personClass1);
        list.add(personClass2);
        list.forEach(x -> {
            Map<String, List<Student>> map = new HashMap<>();
            List<Student> students = x.getStudents();
            students.forEach(y -> {
                if (map.containsKey(y.getGroup())) {
                    map.get(y.getGroup()).add(y);
                } else {
                    map.put(y.getGroup(), Arrays.asList(y));
                }
                //map基于value的size进行排序
            });

        });
    }
}
