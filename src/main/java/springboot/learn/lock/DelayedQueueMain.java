/**
 * @projectName learn
 * @package springboot.learn.lock
 * @className springboot.learn.lock.DelayedQueueMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.lock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayedQueueMain
 *
 * @description 延迟队列
 * @author wangjing
 * @date 2020/9/21 17:38
 * @version v1.0.0
 */
public class DelayedQueueMain {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<MyTimer> delayQueue = new DelayQueue<>();
        delayQueue.offer(new MyTimer(1, TimeUnit.SECONDS));
        delayQueue.offer(new MyTimer(5, TimeUnit.SECONDS));
        delayQueue.offer(new MyTimer(10, TimeUnit.SECONDS));

        System.out.println("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        for (int i = 0; i < 3; i++) {
            MyTimer take = delayQueue.take();
            System.out.format("name:{%s}, time:{%s}\n", take, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }
    }

}


class MyTimer implements Delayed{

    private long time;

    public MyTimer(long time, TimeUnit timeUnit) {
        this.time = System.currentTimeMillis() + (time > 0 ? timeUnit.toMillis(time) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        MyTimer myTimer = (MyTimer)o;
        if(this.time - myTimer.time > 0){
            return 1;
        }else if (this.time < myTimer.time){
            return -1;
        } else {
            return 0;
        }
    }
}