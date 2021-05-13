/**
 * @projectName learn
 * @package springboot.middle.zookeeper.lock
 * @className springboot.middle.zookeeper.lock.ChildrenNodeLock
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.middle.zookeeper.lock;

import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;

import lombok.SneakyThrows;

/**
 * ChildrenNodeLock
 *
 * @description 子节点锁
 * @author wangjing
 * @date 2021/4/9 14:52
 * @version v1.0.0
 */
public class SimpleZkLock extends AbstractZookeeperLock {

    private static final String NODE_NAME = "/test_simple_lock";

    private CountDownLatch countDownLatch;

    @Override
    public boolean tryLock() {
        if (zkClient == null) {
            return false;
        }
        zkClient.createPersistent(NODE_NAME, true);
        return true;
    }

    @SneakyThrows
    @Override
    public void waitLock() {
        IZkDataListener dataListener = new IZkDataListener() {

            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {

            }
        };
        zkClient.subscribeDataChanges(NODE_NAME, dataListener);
        if (zkClient.exists(NODE_NAME)) {
            countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "等待");
        }
        zkClient.unsubscribeDataChanges(NODE_NAME, dataListener);
    }

    @Override
    public void releaseLock() {
        if (zkClient != null) {
            zkClient.delete(NODE_NAME);
            zkClient.close();
            System.out.println(Thread.currentThread().getName() + "释放锁成功");
        }
    }
}
