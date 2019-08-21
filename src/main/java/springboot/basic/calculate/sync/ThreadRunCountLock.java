/**
 * @projectName springbootTest
 * @package springboot.basic.calculate.sync
 * @className springboot.basic.calculate.sync.ThreadRunCountLock
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreadRunCountLock
 *
 * @description lock
 * @author wangjing
 * @date 2019/8/19 18:02
 * @version v1.0.0
 */
public class ThreadRunCountLock implements ThreadRunCount{

    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    @Override public void mainFunction(){
        System.out.println("1.主线程开始"+" -- flag="+flag);
        lock.lock();
        try{
            while(!flag){
                try {
                    System.out.println("2.主线程等待"+" -- flag="+flag);
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("7.主线程开始循环5次"+" -- flag="+flag);
            for(int i=0;i<5;i++){
                System.out.println("mainFunction"+i+" -- flag="+flag);
            }
            flag = false;
            System.out.println("8.唤醒子线程"+" -- flag="+flag);
            con.signal();
        }finally{
            lock.unlock();
        }



    }

    @Override public void subFunction(){
        System.out.println("3.子线程开始"+" -- flag="+flag);
        lock.lock();
        try{
            while(flag){
                try {
                    System.out.println("6.子线程等待"+" -- flag="+flag);
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("4.子线程开始循环3次"+" -- flag="+flag);
            for(int i=0;i<3;i++){
                System.out.println("subFunction"+i+" -- flag="+flag);
            }
            flag = true;
            System.out.println("5.唤醒主线程"+" -- flag="+flag);
            con.signal();
        }finally{
            lock.unlock();
        }
    }
}
