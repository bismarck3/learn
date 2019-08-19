/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.SynchronizedStaticToCommon
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;
/**
 * SynchronizedStaticToCommon
 *
 * @description 同步锁对象与同步锁类
 * @author wangjing
 * @date 2019/8/15 16:15
 * @version v1.0.0
 */
public class SynchronizedStaticToCommon {

    public static synchronized void staticFunction() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running..."+Thread.currentThread().getName());
        }

    }

    public synchronized void function() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("function running..."+Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {
        final SynchronizedStaticToCommon demo = new SynchronizedStaticToCommon();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedStaticToCommon.staticFunction();
//                    demo.function();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.function();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();
        thread3.start();
    }
}


