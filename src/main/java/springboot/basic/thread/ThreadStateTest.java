/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.ThreadStateTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

/**
 * ThreadStateTest
 *
 * @description 线程状态切换
 * @author wangjing
 * @date 2019/8/14 17:58
 * @version v1.0.0
 */

public class ThreadStateTest {

    static Thread getThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行run方法");
                while (true) {
                    if (!Thread.currentThread().isInterrupted()) {
                        System.out.println("线程运行中");
                    } else {
                        System.out.println("线程正常结束");
                        return;
                    }
                }
            }
        });
        return thread;
    }

    public static void main(String[] args) {
        Thread thread = getThread();
        thread.start();
            try {
            Thread.sleep(500);
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
