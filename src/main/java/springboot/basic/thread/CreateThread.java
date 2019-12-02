/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.CreateThread
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

/**
 * CreateThread
 *
 * @description 创建一个线程
 * @author wangjing
 * @date 2019/8/14 15:06
 * @version v1.0.0
 */
public class CreateThread {

    static void createThread(){
        Thread thread = new Thread();
        System.out.println(thread);
        thread.start();
        System.out.println(thread.getThreadGroup());

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2");
            }
        }, "测试线程");
        thread2.start();
        System.out.println(thread2);

        Thread thread3 = new MyThread();
        thread3.start();

    }
    public static void main(String[] args) {
        createThread();
    }

}

class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        System.out.println("runnable");
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread3");
    }
}
