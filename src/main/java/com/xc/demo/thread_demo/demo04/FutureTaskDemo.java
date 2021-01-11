package com.xc.demo.thread_demo.demo04;

import org.junit.Test;

import java.util.concurrent.*;

/**
 *
 */
public class FutureTaskDemo {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        TaskDemo taskDemo = new TaskDemo();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<String> future = executorService.submit(taskDemo);
//        System.out.println(future.get());
        FutureTaskDemo2 futureTaskDemo2 = new FutureTaskDemo2(taskDemo);
        Thread thread1 = new Thread(futureTaskDemo2);
        Thread thread2 = new Thread(futureTaskDemo2);

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        System.out.println(futureTaskDemo2.get());
        Thread.sleep(50000);
//        System.out.println(futureTaskDemo2.get());
    }
}

class TaskDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("执行" + Thread.currentThread().getName());
        Thread.sleep(5000);
        return "1234";
    }
}

class FutureTaskDemo2 extends FutureTask<String> {

    public FutureTaskDemo2(Callable<String> callable) {
        super(callable);
    }

    public FutureTaskDemo2(Runnable runnable, String result) {
        super(runnable, result);
    }
}
