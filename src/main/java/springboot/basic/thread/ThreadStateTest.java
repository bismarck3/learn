/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.ThreadStateTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * ThreadStateTest
 *
 * @description 线程状态切换
 * @author wangjing
 * @date 2019/8/14 17:58
 * @version v1.0.0
 */

public class ThreadStateTest {

    private Object obj;

    void test(){
        //
        //
        //
        synchronized (obj){
            
        }
        //
        //
    }

    static Thread getThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行run方法");
                while (true) {
                    if (!Thread.currentThread().isInterrupted()) {
                        System.out.println("线程运行中");
                    } else {
                        System.out.println("线程正常结束");
                        return;
                    }
                }
            }
        });
        return thread;
    }

    public static void main(String[] args) {
        Thread thread = getThread();
        ThreadStateTest threadStateTest = new ThreadStateTest();
        ThreadStateTest threadStateTest2 = new ThreadStateTest();

        threadStateTest.test();
        threadStateTest2.test();
        thread.start();
            try {
            Thread.sleep(100);
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Runnabele3 implements Runnable{

    ThreadLocal<Boolean> flag;

    @Override
    public void run() {
        while(true){
            if(flag.get()){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
            flag.set(!flag.get());
        }
    }
}