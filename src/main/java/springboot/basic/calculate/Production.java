/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.Production
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;


/**
 * Production
 *
 * @author wangjing
 * @version v1.0.0
 * @description 产品
 * @date 2019/8/19 13:58
 */
public class Production {

    private int maxSize;

    private int resouces;

    private Object lock;

    public Production(int maxSize, int resouces, Object lock) {
        this.maxSize = maxSize;
        this.resouces = resouces;
        this.lock = lock;
    }

    public void consumer() {
        while (true) {
            synchronized (lock) {
                if (resouces - 1 < 0) {
                    System.out.println("可消费的资源不足，" + Thread.currentThread().getName() + "阻塞等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println("阻塞过程中被中断。");
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"被唤醒");
                } else {
                    resouces--;
                    try {
                        Thread.currentThread().sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费线程" + Thread.currentThread().getName() + "消费了资源，资源剩余：" + resouces);
                    lock.notifyAll();
                }
            }
        }
    }

    public void produce() {
        while (true) {
            synchronized (lock) {
                if (resouces > maxSize - 1) {
                    System.out.println("可生产的资源空间不足，" + Thread.currentThread().getName() + "阻塞等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println("阻塞过程中被中断。");
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"被唤醒");
                } else {
                    resouces++;
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("生产线程" + Thread.currentThread().getName() + "生产了资源，资源剩余：" + resouces);
                    lock.notifyAll();
                }
            }
        }
    }


}
