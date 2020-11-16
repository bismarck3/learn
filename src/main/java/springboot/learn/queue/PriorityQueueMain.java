/**
 * @projectName learn
 * @package springboot.learn.queue
 * @className springboot.learn.queue.PriorityQueueMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.queue;

import java.util.PriorityQueue;

/**
 * PriorityQueueMain
 *
 * @description 优先级队列
 * @author wangjing
 * @date 2020/11/13 14:15
 * @version v1.0.0
 */
public class PriorityQueueMain {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.poll();
        System.out.println(priorityQueue);
    }
}
