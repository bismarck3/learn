/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.SemaphoreTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreTest
 *
 * @description 信号量测试
 * @author wangjing
 * @date 2019/8/19 18:14
 * @version v1.0.0
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    static void test(){
        Semaphore semaphore = new Semaphore(2);
        MyRunnable myRunnable = new MyRunnable(semaphore);
        Thread thread = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);
        thread.start();
        thread2.start();
        thread3.start();
    }
}


class MyRunnable implements Runnable{

    private Semaphore semaphore;

    public MyRunnable(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override public void run() {
        try {
            while(true){
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"获取资源");
                Thread.sleep(1000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName()+"释放资源");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}