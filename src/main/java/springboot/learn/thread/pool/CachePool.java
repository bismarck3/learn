package springboot.learn.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * CachePool
 * @description cacheThreadPool
 * @author wangj
 * @date 2019年1月8日 下午6:15:33
 * @version TODO
 */
public class CachePool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i =0 ; i < 20 ; i ++) {
            final int indedx = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+indedx);
            });
        }
    }
}
