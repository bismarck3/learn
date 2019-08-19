/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.ThreadInfo
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

/**
 * ThreadInfo
 *
 * @description 后台线程与普通线程
 * @author wangjing
 * @date 2019/8/14 14:56
 * @version v.1.0.0
 */
public class ThreadInfo {

    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        String groupName = Thread.currentThread().getThreadGroup().getName();
        boolean isDaemon = Thread.currentThread().isDaemon();
        boolean isAlive = Thread.currentThread().isAlive();
        System.out.println("Thread Name:" + name);
        System.out.println("poiority:" + priority);
        System.out.println("groupName:" + groupName);
        System.out.println("isDaemon:" + isDaemon);
        System.out.println("isAlive:" + isAlive);
        System.out.println("-------------");
        Thread.currentThread().setName("Test_修改后名字");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        name = Thread.currentThread().getName();
        priority = Thread.currentThread().getPriority();
        groupName = Thread.currentThread().getThreadGroup().getName();
        isDaemon = Thread.currentThread().isDaemon();
        System.out.println("Thread Name:" + name);
        System.out.println("Priority:" + priority);
        System.out.println("Thread groupName:" + groupName);
        System.out.println("Thread isDaemon:" + isDaemon);
    }
}
