/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.RunnableToExtend
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;
/**
 * RunnableToExtend
 *
 * @description runnable与继承线程
 * @author wangjing
 * @date 2019/8/14 17:24
 * @version v1.0.0
 */
public class RunnableToExtend {

    static void testExtendThread(){
        Thread thread = new MyExtendThread("售票线程1");
        Thread thread2 = new MyExtendThread("售票线程2");
        Thread thread3 = new MyExtendThread("售票线程3");
        thread.start();
        thread2.start();
        thread3.start();
    }

    static void testRunnable(){
        MyRunnableThread myRunnableThread = new MyRunnableThread();

        Thread thread = new Thread(myRunnableThread, "售票线程1");
        Thread thread2 = new Thread(myRunnableThread, "售票线程2");
        Thread thread3 = new Thread(myRunnableThread, "售票线程3");
        thread.start();
        thread2.start();
        thread3.start();
    }


    public static void main(String[] args) {
        testRunnable();
    }
}

class MyRunnableThread implements Runnable{

    private int ticket = 100;

    @Override public void run() {
        while(ticket > 0){
            ticket--;
            System.out.println(Thread.currentThread().getName()+"-ticket："+ticket);
        }
    }
}



class MyExtendThread extends Thread{

    private int ticket = 100;

    public MyExtendThread(String name) {
        super(name);
    }

    @Override public void run() {
        while(ticket > 0){
            ticket--;
            System.out.println(Thread.currentThread().getName()+"-ticket："+ticket);
        }
    }
}