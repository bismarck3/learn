/**
 * @projectName learn
 * @package springboot.learn.queue
 * @className springboot.learn.queue.SynchroousQueueMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.queue;

import java.util.concurrent.SynchronousQueue;

import lombok.SneakyThrows;

/**
 * SynchroousQueueMain
 *
 * @description 同步队列
 * @author wangjing
 * @date 2020/11/12 10:47
 * @version v1.0.0
 */
public class SynchronousQueueMain {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.put(1);
            }
        }, "put");
        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                queue.take();
            }
        }, "take");
        thread.start();
        thread2.start();
        while(true){

        }
    }
}
