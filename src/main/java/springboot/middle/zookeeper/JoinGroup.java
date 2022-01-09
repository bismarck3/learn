/**
 * @projectName learn
 * @package springboot.middle.zookeeper
 * @className springboot.middle.zookeeper.JoinGroup
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.middle.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

/**
 * JoinGroup
 *
 * @description join
 * @author wangjing
 * @date 2021/4/8 20:39
 * @version v1.0.0
 */
public class JoinGroup extends ConnectionWatcher {

    public void join(String groupName, String memberName) throws KeeperException, InterruptedException {
        String path = "/" + groupName + "/" + memberName;
        String createPath = zooKeeper.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(createPath);
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        JoinGroup joinGroup = new JoinGroup();
        joinGroup.connect();
        joinGroup.join("c", "aa");
        Thread.sleep(Long.MAX_VALUE);
    }
}
