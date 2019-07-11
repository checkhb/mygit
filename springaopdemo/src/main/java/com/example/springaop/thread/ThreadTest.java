package com.example.springaop.thread;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/25 9:47
 * @Version 1.0
 */
public class ThreadTest {
    public static void attack(){
        System.out.println("attack");
        System.out.println("current thread is:" + Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run(){
                attack();
            }
        };
        System.out.println("current main thread is:" + Thread.currentThread().getName());
        thread.start();
    }
}
