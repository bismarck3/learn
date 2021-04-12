/**
 * @projectName learn
 * @package springboot.learn.zookeeper.lock
 * @className springboot.learn.zookeeper.lock.Main
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.zookeeper.lock;

import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

/**
 * Main
 *
 * @description 主方法
 * @author wangjing
 * @date 2021/4/9 15:19
 * @version v1.0.0
 */
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new LockRunnable());
            thread.start();
        }
        TimeUnit.HOURS.sleep(1);
    }
}

class LockRunnable implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        AbstractZookeeperLock zkLock = new SimpleZkLock();
        zkLock.getLock();
        TimeUnit.SECONDS.sleep(1);
        zkLock.releaseLock();
    }
}
