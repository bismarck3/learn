package springboot.learn.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 让所有这个类下面的静态方法和非静态方法共用同一把锁的时候，可以使用Lock
 * Demo
 */
public class Demo {

    private List<Object> objectList = new ArrayList<>();

    private static List<Object> objectList2 = new ArrayList<>();

    public static synchronized void staticFunction() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running..."+Thread.currentThread().getName());
        }

    }

    public void function() throws InterruptedException {
        synchronized(this) {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                System.out.println("function running..."+Thread.currentThread().getName());
                this.wait();
                System.out.println(Thread.currentThread().getName() + "阻塞结束");
            }
        }

    }

    public synchronized void function2() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("function running..."+Thread.currentThread().getName());
            this.notifyAll();
        }

    }

    public void listFunction() throws InterruptedException {
        synchronized (objectList){
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                System.out.println("List function running..."+Thread.currentThread().getName());
            }
        }
    }

    public static void listStaticFunction() throws InterruptedException {
        synchronized (objectList2){
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                System.out.println("StaticList function running..."+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        final Demo demo = new Demo();
        new Thread(() -> {
            try {
                demo.function();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                demo.function2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}