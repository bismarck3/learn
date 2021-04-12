/**
 * @projectName learn
 * @package springboot.learn.zookeeper.lock
 * @className springboot.learn.zookeeper.lock.AbstractZookeeperLock
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.zookeeper.lock;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.ZooKeeper;
import org.I0Itec.zkclient.ZkClient;


/**
 * AbstractZookeeperLock
 *
 * @description 抽象锁父类
 * @author wangjing
 * @date 2021/4/9 11:01
 * @version v1.0.0
 */
public abstract class AbstractZookeeperLock {

    private static final int SESSION_TIMEOUT = 5000;

    private static final String HOST = "172.25.17.131:2181";

    protected ZkClient zkClient = new ZkClient(HOST, SESSION_TIMEOUT);

    public void getLock() {
        String name = Thread.currentThread().getName();
        if (tryLock()) {
            System.out.println(name + "获取锁成功");
        } else {
            System.out.println(name + "获取锁失败");
            waitLock();
            getLock();
        }
    }

    public abstract boolean tryLock();

    public abstract void waitLock();

    public abstract void releaseLock();
}
