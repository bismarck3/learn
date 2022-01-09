/**
 * @projectName learn
 * @package springboot.middle.zookeeper
 * @className springboot.middle.zookeeper.ListGroup
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.middle.zookeeper;

import java.util.List;

import org.apache.zookeeper.KeeperException;

/**
 * ListGroup
 *
 * @description 列举节点
 * @author wangjing
 * @date 2021/4/8 20:45
 * @version v1.0.0
 */
public class ListGroup extends ConnectionWatcher {

    public void list(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        List<String> children = zooKeeper.getChildren(path, false);
        if (children.isEmpty()) {
            System.out.println("children is empty");
            System.exit(1);
        }
        System.out.println("----------");
        for (String child : children) {
            System.out.println(child);
        }
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        ListGroup listGroup = new ListGroup();
        listGroup.connect();
        listGroup.list("");
        listGroup.close();
    }
}
