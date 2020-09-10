/**
 * @projectName learn
 * @package springboot.learn.thread.cas
 * @className springboot.learn.thread.cas.AtomicTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread.cas;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * AtomicTest
 *
 * @description cas测试
 * @author wangjing
 * @date 2020/9/3 10:02
 * @version v1.0.0
 */
public class AtomicTest {

    private static final Unsafe unsafe;

    private static final long valueOffset;

    static {
        try {
            Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            unsafe = (Unsafe)singleoneInstanceField.get(null);
            valueOffset = unsafe.objectFieldOffset
                (springboot.learn.thread.cas.AtomicTest.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private int value;

    public AtomicTest(int initialValue) {
        value = initialValue;
    }

    public final void incrementAndGet() {
        while(!unsafe.compareAndSwapInt(this, valueOffset, value, value + 1)){}
    }

    public final int get() {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicTest atomicTest = new AtomicTest(0);
        for(int i = 0 ; i < 10 ; i++){
            MyThread myThread = new MyThread(atomicTest);
            myThread.start();
            myThread.join();
        }
        Thread.sleep(5000);
        System.out.println(atomicTest.get());
    }
}

class MyThread extends Thread{

    AtomicTest atomicTest;

    public MyThread(AtomicTest atomicTest) {
        this.atomicTest = atomicTest;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 1000000 ; i++){
           atomicTest.incrementAndGet();
        }
    }
}
