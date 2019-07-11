package com.example.springaop.thread;

/**
 * @Desc
 * @Author hubin
 * @Date 2019/6/25 15:15
 * @Version 1.0
 */
public class NotifyAndNotityallDemo {
    private volatile boolean go = false;

    public static void main(String[] args) throws InterruptedException {

        final NotifyAndNotityallDemo test = new NotifyAndNotityallDemo();

     Runnable waitTask = new Runnable(){
            @Override
            public void run() {
                try{
                    test.shouldGo();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finished Execution");

            }
        };

     Runnable notifyTask = new Runnable() {
         @Override
         public void run() {
             test.go();
             System.out.println(Thread.currentThread().getName() + " finished Execution");
         }
     };
     Thread t1 = new Thread(waitTask,"WT1");
     Thread t2 = new Thread(waitTask,"WT2");
     Thread t3 = new Thread(waitTask,"WT3");
     Thread t4 = new Thread(notifyTask,"NT4");

     t1.start();
     t2.start();
     t3.start();

     Thread.sleep(200);

     t4.start();

    }

    private synchronized void shouldGo() throws InterruptedException{
        while (go!=true){
            System.out.println(Thread.currentThread()+" is going to wait on this object");
            wait();
            System.out.println(Thread.currentThread().getName() + " is woken up");
        }
        go = false;
    }

    private synchronized void go(){
        while (go == false){
            System.out.println(Thread.currentThread() + " is going to notify all or one thread");
            go = true;
            //notifyall()：进入等待池中的所有线程进入锁池中竞争获取锁的机会
            //进入等待中的随机一个线程进入锁池中竞争获取锁的机会
            notify();
            //notifyAll();
        }
    }
}
