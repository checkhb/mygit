package com.example.springaop.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hubin
 */
public class ReentrantLockDemo implements Runnable {
    //fair=true 是公平锁，就是获取锁的概率相同，false是随机的。
    private static ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                //让线程睡一秒，就是阻塞一秒（让出cpu一秒）
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //必须释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo rtld = new ReentrantLockDemo();
        Thread thread1 = new Thread(rtld);
        Thread thread2 = new Thread(rtld);
        thread1.start();
        thread2.start();
    }
}
