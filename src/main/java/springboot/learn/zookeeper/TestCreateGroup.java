/**
 * @projectName learn
 * @package springboot.learn.zookeeper
 * @className springboot.learn.zookeeper.CreateGroup
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * CreateGroup
 *
 * @description 创建节点
 * @author wangjing
 * @date 2021/4/8 20:12
 * @version v1.0.0
 */
public class TestCreateGroup implements Watcher {
    private static final int SESSION_TIMEOUT=5000;
    private static final String HOST1="172.25.17.131:2181";
    private static final String HOST2="192.168.56.90:2182,192.168.56.90:2183,192.168.56.90:2184";

    private ZooKeeper zk;
    private CountDownLatch connectedSignal=new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        if(event.getState()== Event.KeeperState.SyncConnected){
            connectedSignal.countDown();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        TestCreateGroup createGroup = new TestCreateGroup();
        createGroup.connect(HOST1);
        createGroup.create("c");
        createGroup.close();
    }

    private void close() throws InterruptedException {
        zk.close();
    }

    private void create(String groupName) throws KeeperException, InterruptedException {
        String path="/"+groupName;
        if(zk.exists(path, false)== null) {
            zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        System.out.println("Created:"+path);
    }

    private void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        connectedSignal.await();
    }
}
