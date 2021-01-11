package com.xc.demo.lock;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

public class SynchronizedDemo {

    @Test
    public void test1() {
        new Thread(() -> {
            Queue<String> queue = new ConcurrentLinkedQueue();
            queue.add("abc");
            queue.add("efg");

            Queue<String> queue2 = new ConcurrentLinkedQueue();
            queue2.add("abc");
            queue2.add("efg");
        }).start();

        System.out.println(111111);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Inner inner1 = new Inner();
        Inner inner2 = new Inner();
        System.out.println(inner1 == inner2);
    }

    private static class Inner{

    }
}
