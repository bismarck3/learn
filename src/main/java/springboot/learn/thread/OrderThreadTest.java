/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.OrderThreadTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * OrderThreadTest
 *
 * @description 线程顺序执行
 * @author wangjing
 * @date 2020/7/22 10:39
 * @version v1.0.0
 */
public class OrderThreadTest {

    static void reentryLock(){
        Lock lock = new ReentrantLock();
        Condition read = lock.newCondition();
        new Thread(() -> {
            while(true){
                lock.lock();
                read.signal();
                try {
                    read.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行");
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            while(true){
                lock.lock();
                read.signal();
                try {
                    read.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行");
                lock.unlock();
            }
        }).start();

    }

    static void synchronize(){
        Object object = new Object();
        Thread thread = new Thread(() -> {
            while(true){
                synchronized (object){
                    try {
                        object.notify();
                        System.out.println(Thread.currentThread().getName());
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while(true){
                synchronized (object){
                    try {
                        object.notify();
                        System.out.println(Thread.currentThread().getName());
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread2.start();
    }

    static void excutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread thread = new Thread(() -> {
            System.out.println("i'm 1");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("i'm 2");
        });
        while (true){
            executorService.execute(thread);
            executorService.execute(thread2);
        }
    }

    static void semaphore() throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        semaphore2.acquire();
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    semaphore2.acquire();
                    System.out.println(Thread.currentThread().getName());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
    }

    static void joinThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.join();
        thread.start();
        thread2.join();
        thread2.start();
    }

    static void countDownLatch(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        countDownLatch2.countDown();
        Thread thread = new Thread(() -> {
            while(true){
                try {
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
           while(true){
               try {
                   countDownLatch.await();
                   System.out.println(Thread.currentThread().getName());
                   countDownLatch2.countDown();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        thread.start();
        thread2.start();
    }

    static void cyclicBarrierTest(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
        Thread thread = new Thread(() -> {
            while(true){
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier1.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while(true){
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier1.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        cyclicBarrierTest();
    }

}
