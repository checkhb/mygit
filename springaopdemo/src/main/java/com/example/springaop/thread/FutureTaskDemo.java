package com.example.springaop.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/25 14:27
 * @Version 1.0
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        new Thread(futureTask).start();
        if(!futureTask.isDone()){
            System.out.println("task no finished,please wait!");
        }
        System.out.println("task retrun:"+futureTask.get());
    }
}
