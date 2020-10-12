/**
 * @projectName learn
 * @package springboot.learn.lock
 * @className springboot.learn.lock.ReadWriteLock
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * ReadWriteLock
 *
 * @description ReadWriteLock
 * @author wangjing
 * @date 2020/9/21 13:47
 * @version v1.0.0
 */
public class ReadWriteLockMain {

    public static void main(String[] args) {
//        readWriteLock();
        stampedLock();
    }

    private static void stampedLock(){
        StampedLock stampedLock = new StampedLock();
        for(int i = 0 ; i < 10; i ++){
            new Thread(new ReadRunnableSta(stampedLock)).start();
        }
        for(int i = 0 ; i < 5; i ++){
            new Thread(new WriteRunnableSta(stampedLock)).start();
        }
    }

    private static void readWriteLock() {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        for(int i = 0 ; i < 10; i ++){
            new Thread(new ReadRunnable(readWriteLock)).start();
        }
        for(int i = 0 ; i < 5; i ++){
            new Thread(new WriteRunnable(readWriteLock)).start();
        }
    }
}

class ReadRunnableSta implements Runnable{

    private StampedLock stampedLock;

    public ReadRunnableSta(StampedLock stampedLock) {
        this.stampedLock = stampedLock;
    }

//    @lombok.SneakyThrows
//    @Override
//    public void run() {
//        while(true){
//            long lock = stampedLock.readLock();
//            Thread.sleep(100);
//            System.out.println(Thread.currentThread().getName()+ "\tread");
//            stampedLock.unlockRead(lock);
//        }
//    }

    /** 乐观锁 */
    @lombok.SneakyThrows
    @Override
    public void run() {
        while(true){
            long lock = stampedLock.tryOptimisticRead();
            System.out.println("读取数据");
            Thread.sleep(100);
            if(!stampedLock.validate(lock)){
                long stamped = stampedLock.readLock();
                System.out.println("读取数据");
                stampedLock.unlockRead(stamped);
            }
            System.out.println(Thread.currentThread().getName()+ "\tread");
        }
    }

}

class WriteRunnableSta implements Runnable{

    private StampedLock stampedLock;

    public WriteRunnableSta(StampedLock stampedLock) {
        this.stampedLock = stampedLock;
    }

    @lombok.SneakyThrows
    @Override
    public void run() {
        while(true){
            long lock = stampedLock.writeLock();
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName()+ "\twrite");
            stampedLock.unlockWrite(lock);
        }
    }

}



class ReadRunnable implements Runnable{

    private ReadWriteLock readWriteLock;

    public ReadRunnable(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @lombok.SneakyThrows
    @Override
    public void run() {
        while(true){
            Lock lock = readWriteLock.readLock();
            lock.lock();
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName()+ "\tread");
            lock.unlock();
        }
    }
}

class WriteRunnable implements Runnable{

    private ReadWriteLock readWriteLock;

    public WriteRunnable(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @lombok.SneakyThrows
    @Override
    public void run() {
        while(true){
            Lock lock = readWriteLock.writeLock();
            lock.lock();
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+ "\twrite");
            lock.unlock();
        }
    }
}
