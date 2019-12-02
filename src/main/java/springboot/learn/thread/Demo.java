package springboot.learn.thread;

/**
 * 让所有这个类下面的静态方法和非静态方法共用同一把锁的时候，可以使用Lock
 * Demo
 */
public class Demo {
    
    public static synchronized void staticFunction() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running..."+Thread.currentThread().getId());
        }

    }

    public synchronized void function() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("function running..."+Thread.currentThread().getId());
        }

    }

    public static void main(String[] args) {
        final Demo demo = new Demo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    staticFunction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.function();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.function();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}