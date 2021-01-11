package com.xc.demo.thread_demo.demo04;

import org.junit.Test;

public class demo01 {

    static Object object = new Object();

    /**
     * Object的wait方法。必须在持有该对象的synchronized方法中执行。
     */
    @Test
    public void test1 () {
        try {
            synchronized (object) {
                System.out.println(1);
                object.wait(1000);
                System.out.println(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
