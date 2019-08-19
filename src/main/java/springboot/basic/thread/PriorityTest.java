/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.PriorityTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;
/**
 * PriorityTest
 *
 * @description 优先级测试
 * @author wangjing
 * @date 2019/8/14 16:53
 * @version v1.0.0
 */
public class PriorityTest {

    public static void main(String[] args) {
        Thread lowPriorityThread = new Thread(new Runnable() {
            @Override public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println(Thread.currentThread().getName()+"："+i);
                }
            }
        }, "lowPriorityThread");

        Thread highPriorityThread = new Thread(new Runnable() {
            @Override public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println(Thread.currentThread().getName()+"："+i);
                }
            }
        }, "highPriorityThread");

        lowPriorityThread.setPriority(1);
        highPriorityThread.setPriority(2);
        lowPriorityThread.start();
        highPriorityThread.start();
    }

}
