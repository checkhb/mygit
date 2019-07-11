package com.example.springaop.thread;

import java.util.concurrent.Callable;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/25 14:22
 * @Version 1.0
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}
