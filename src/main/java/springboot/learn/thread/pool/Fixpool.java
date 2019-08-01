package springboot.learn.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * Fix
 * @description FixedThreadPool
 * @author wangj
 * @date 2019年1月8日 下午6:14:59
 * @version TODO
 */
public class Fixpool {

    public static void main(String[] args) {
        ExecutorService exc = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            final int index = i;
            exc.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t"+index);
            });
        }
        
        
    }
}
