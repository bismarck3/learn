/**
 * @projectName learn
 * @package springboot.middle.zookeeper
 * @className springboot.middle.zookeeper.ConnectionWatcher
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.middle.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * ConnectionWatcher
 *
 * @description 链接watcher
 * @author wangjing
 * @date 2021/4/8 20:36
 * @version v1.0.0
 */
public class ConnectionWatcher implements Watcher {

    private static final int SESSION_TIMEOUT = 5000;

    private static final String HOST = "172.25.17.131:2181";

    protected ZooKeeper zooKeeper;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void connect(){
        try {
            zooKeeper = new ZooKeeper(HOST, SESSION_TIMEOUT, this);
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}
