/**
 * @projectName learn
 * @package springboot.learn.zookeeper
 * @className springboot.learn.zookeeper.config.ActiveKeyValueStore
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.zookeeper.config;

import java.nio.charset.Charset;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import springboot.learn.zookeeper.ConnectionWatcher;

/**
 * ActiveKeyValueStore
 *
 * @description 配置key
 * @author wangjing
 * @date 2021/4/8 22:37
 * @version v1.0.0
 */
public class ActiveKeyValueStore extends ConnectionWatcher {

    public void write(String path, String value) {
        try {
            Stat exists = zooKeeper.exists(path, false);
            if (exists == null) {
                zooKeeper.create(path, value.getBytes(Charset.defaultCharset()), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            } else {
                zooKeeper.setData(path, value.getBytes(Charset.defaultCharset()), -1);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String read(String path, Watcher watcher) {
        byte[] data = new byte[0];
        try {
            data = zooKeeper.getData(path, watcher, null);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new String(data, Charset.defaultCharset());
    }
}
