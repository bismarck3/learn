/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.Production
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import java.util.LinkedList;

/**
 * Production
 *
 * @description 产品
 * @author wangjing
 * @date 2019/8/19 13:58
 * @version v1.0.0
 */
public class Production {

    private int maxSize;

    private LinkedList<Object> producer = new LinkedList<>();

    public Production(int maxSize) {
        this.maxSize = maxSize;
    }

    public void consumer(){
        synchronized (producer){
            while(producer.size() < 0){
                System.out.println("可消费的资源不足，"+Thread.currentThread().getName()+"阻塞等待");
                try {
                    producer.wait();
                } catch (InterruptedException e) {
                    System.err.println("阻塞过程中被中断。");
                    e.printStackTrace();
                }
            }
            producer.remove();
            System.out.println("消费线程"+Thread.currentThread().getName()+"消费了资源，资源剩余："+producer.size());
            producer.notifyAll();
        }
    }

    public void produce(){
        synchronized (producer){
            while(producer.size() > maxSize - 1){
                System.out.println("可生产的资源空间不足，"+Thread.currentThread().getName()+"阻塞等待");
                try {
                    producer.wait();
                } catch (InterruptedException e) {
                    System.err.println("阻塞过程中被中断。");
                    e.printStackTrace();
                }
            }
            producer.add(new Object());
            System.out.println("生产线程"+Thread.currentThread().getName()+"生产了资源，资源剩余："+producer.size());
            producer.notifyAll();
        }

    }


}
