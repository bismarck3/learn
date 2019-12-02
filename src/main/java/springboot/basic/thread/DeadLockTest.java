/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.DeadLockTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;
/**
 * DeadLockTest
 *
 * @description 死锁测试
 * @author wangjing
 * @date 2019/8/15 16:05
 * @version v1.0.0
 */
public class DeadLockTest {

    public static void main(String[] args) {
        Object lock = new Object();
        Object lock2 = new Object();
        Thread thread = new Thread(new MyDeadRunnable(lock, lock2));
        Thread thread2 = new Thread(new MyDeadRunnable2(lock, lock2));
        thread.start();
        thread2.start();
    }
}

class MyDeadRunnable implements Runnable{

    private Object lock;

    private Object lock2;

    public MyDeadRunnable(Object lock, Object lock2) {
        this.lock = lock;
        this.lock2 = lock2;
    }

    @Override public void run() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"——进入lock1的临界区");
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"——进入lock2的临界区");
            }
        }
        System.out.println(Thread.currentThread().getName()+"——同步块执行完毕，退出");
    }
}


class MyDeadRunnable2 implements Runnable{

    private Object lock;

    private Object lock2;

    public MyDeadRunnable2(Object lock, Object lock2) {
        this.lock = lock;
        this.lock2 = lock2;
    }

    @Override public void run() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"——进入lock2的临界区");
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"——进入lock1的临界区");
            }
        }
        System.out.println(Thread.currentThread().getName()+"——同步块执行完毕，退出");
    }
}

