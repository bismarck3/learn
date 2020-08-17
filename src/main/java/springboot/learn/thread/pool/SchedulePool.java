/**
 * @projectName springbootTest
 * @package springboot.learn.thread.pool
 * @className springboot.learn.thread.pool.SchedulePool
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * SchedulePool
 *
 * @description 定时调度
 * @author wangjing
 * @date 2020/8/17 14:43
 * @version v1.0.0
 */
public class SchedulePool {

    static void rate(ScheduledExecutorService scheduledExecutorService, Runnable runnable){
        scheduledExecutorService.scheduleAtFixedRate(runnable, 0, 2, TimeUnit.SECONDS);
    }

    static void delay(ScheduledExecutorService scheduledExecutorService, Runnable runnable){
        scheduledExecutorService.scheduleWithFixedDelay(runnable, 0, 2, TimeUnit.SECONDS);
    }

    static Runnable getRunnable(){
        return new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        delay(scheduledExecutorService, getRunnable());
    }
}
