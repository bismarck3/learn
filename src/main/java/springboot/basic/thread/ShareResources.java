/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.ShareResources
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ShareResources
 *
 * @description 线程共享资源
 * @author wangjing
 * @date 2019/8/15 15:46
 * @version v1.0.0
 */
public class ShareResources {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnableSync();
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable{

    private int tickets = 7;

    @Override public void run() {
        while(tickets > 0){
            System.out.println(Thread.currentThread().getName()+"——tickets:"+tickets);
            tickets--;
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}



class MyRunnableSync implements Runnable{

    private int tickets = 7;

    @Override public void run() {
        while(tickets > 0){
            synchronized (this){
            System.out.println("tickets:"+tickets);
            tickets--;
            }
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}


class MyRunnableVolatle implements Runnable{

    private volatile int tickets = 100;

    @Override public void run() {
        synchronized (this){
            while(tickets > 0){
                System.out.println("tickets:"+tickets);
                tickets--;
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyRunnableAutomic implements Runnable{


    private AtomicInteger tickets = new AtomicInteger(7);

    @Override public void run() {
            while(tickets.get() > 0){
                System.out.println("tickets:"+tickets);
                tickets.decrementAndGet();
                tickets.incrementAndGet();
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
    }
}

class MyRunnableReen implements Runnable{

    private ReentrantLock reentrantLock;

    private volatile int tickets = 100;

    private Object obj;

    private Object obj2;

    public synchronized void run2(){
    }

    public static synchronized void run3(){

    }

    @Override
    public void run() {
        while(tickets > 0){
            reentrantLock.lock();
            synchronized (this){
                System.out.println("tickets:"+tickets);
                tickets--;
            }
            reentrantLock.unlock();
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
