package com.example.springaop.thread;

/**
 * @author hubin
 */
public class SynchronizedDemo {
    public void synocsTask() {
        synchronized (this){
            System.out.println("Hello");
        }
    }
    public synchronized void syncTask() {
        System.out.println("hello again");
    }
}
