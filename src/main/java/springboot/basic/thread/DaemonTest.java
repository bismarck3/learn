/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.DaemonTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;
/**
 * DaemonTest
 *
 * @description 后台线程测试
 * @author wangjing
 * @date 2019/8/14 16:58
 * @version V1.0.0
 */
public class DaemonTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println(Thread.currentThread().getName()+"："+i);
                }
            }
        }, "业务线程（非后台线程）");
        Thread daemonThread = new Thread(new Runnable() {
            @Override public void run() {
                while(true){
                    System.out.println("我是后台线程");
                }
            }
        },"后台线程");
        daemonThread.setDaemon(true);
        daemonThread.start();
        thread.start();
    }
}
