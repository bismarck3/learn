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

    public synchronized void function() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("function running..."+Thread.currentThread().getName());
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
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    staticFunction();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    demo.listFunction();
                    demo.staticFunction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    Demo.staticFunction();
//                    demo.listFunction();
//                    Demo.listStaticFunction();
                    demo.function();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();
        thread3.start();
    }
}