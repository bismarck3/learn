/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.CountDownLatchTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchTest
 *
 * @description 
 * @author wangjing
 * @date 2019/8/19 18:21
 * @version 
 */
public class CountDownLatchTest {

    static void order(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        new Thread(() -> {
            while(true){
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch1.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while(true){
                countDownLatch1.countDown();
                try {
                    countDownLatch1.await();
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        order();
    }


    static void test(){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        MyRunnble myRunnable = new MyRunnble(countDownLatch);
        Thread thread = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        thread.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnble implements Runnable{

    private CountDownLatch countDownLatch;

    public MyRunnble(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"进入线程"+System.currentTimeMillis());
            Thread.sleep(new Random().nextInt(10000)+1000);
            System.out.println(Thread.currentThread().getName()+"方法执行完毕"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName()+"等待其他线程执行，进入阻塞"+System.currentTimeMillis());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"等待其他线程执行完毕"+System.currentTimeMillis());
    }
}
