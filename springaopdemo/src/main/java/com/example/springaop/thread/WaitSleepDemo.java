package com.example.springaop.thread;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/25 10:07
 * @Version 1.0
 */
public class WaitSleepDemo {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread A is get lock");
                        //只让出cpu，不会释放锁
                        Thread.sleep(20);
                        System.out.println("thead A do wait method");
                        //只让出cpu，也释放锁1s钟
                        //lock.wait(1000);
                        //lock.wait();
                        Thread.sleep(1000);
                        System.out.println("thead A is done");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread B is waiting to get lock");
            synchronized (lock){
                try {
                    System.out.println("thread B is get lock");
                    //只让出cpu，不会释放锁
                    lock.wait(10);
                    System.out.println("thead B is done");
                    //释放其他线程的锁
                   // lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }).start();
}

}
