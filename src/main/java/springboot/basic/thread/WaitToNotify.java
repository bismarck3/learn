/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.WaitToNotify
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

/**
 * WaitToNotify
 *
 * @description 等待与唤醒测试
 * @author wangjing
 * @date 2019/8/15 15:16
 * @version v1.0.0
 */
class Consummer extends Thread {

    private Object lock;

    public Consummer(Object lock, String name) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + "——开始等待");
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "——阻塞之后被唤醒");
        }
    }
}

class Producer extends Thread {

    private Object lock;

    public Producer(Object lock, String name) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "——唤醒线程");
            lock.notify();
        }
    }
}

public class WaitToNotify {

    public static void main(String[] args) {
        Object lock = new Object();
        Object lock2 = new Object();
        Consummer consummer = new Consummer(lock, "消费线程");
        Producer producer = new Producer(lock2, "生产线程");
        consummer.start();
        producer.start();
    }
}
