package com.example.springaop.lock;

/**
 * @author hubin
 */
public class DieThread {
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "get o1 lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "wait o2 lock");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "get o2 lock");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "get o2 lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "wait o1 lock");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "get o1 lock");
                }
            }
        }, "线程2").start();


    }
}
