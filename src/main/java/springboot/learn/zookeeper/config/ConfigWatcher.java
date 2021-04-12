/**
 * @projectName learn
 * @package springboot.learn.zookeeper.config
 * @className springboot.learn.zookeeper.config.ConfigWatcher
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.zookeeper.config;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * ConfigWatcher
 *
 * @description 配置wathcer
 * @author wangjing
 * @date 2021/4/8 22:47
 * @version v1.0.0
 */
public class ConfigWatcher implements Watcher {

    private ActiveKeyValueStore activeKeyValueStore;

    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.NodeDataChanged) {
            displayConfig();
        }
    }

    public ConfigWatcher() {
        activeKeyValueStore = new ActiveKeyValueStore();
        activeKeyValueStore.connect();
    }

    public void displayConfig() {
        String read = activeKeyValueStore.read(ConfigUpdater.PATH, this);
        System.out.printf("read %s as %s\n", ConfigUpdater.PATH, read);
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigWatcher configWatcher = new ConfigWatcher();
        configWatcher.displayConfig();
        Thread.sleep(Long.MAX_VALUE);
    }
}
