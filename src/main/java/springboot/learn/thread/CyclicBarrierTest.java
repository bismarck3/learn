/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.CyclicBarrierTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * CyclicBarrierTest
 *
 * @description 栅栏测试
 * @author wangjing
 * @date 2019/8/21 15:59
 * @version v1.0.0
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override public void run() {
                System.out.println("全部线程到达栅栏.");
            }
        });
        MyRunnableCyclicBarrier myRunnableCyclicBarrier = new MyRunnableCyclicBarrier(cyclicBarrier);
        Thread thread = new Thread(myRunnableCyclicBarrier);
        Thread thread2 = new Thread(myRunnableCyclicBarrier);
        Thread thread3 = new Thread(myRunnableCyclicBarrier);
        thread.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnableCyclicBarrier implements Runnable{

    private CyclicBarrier cyclicBarrier;

    public MyRunnableCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override public void run() {
        try {
            while(true){
                System.out.println(Thread.currentThread().getName()+"获取资源");
                Thread.sleep(2000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"释放资源");
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}