/**
 * @projectName learn
 * @package springboot.learn.zookeeper
 * @className springboot.learn.zookeeper.config.ConfigUpdater
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.zookeeper.config;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * ConfigUpdater
 *
 * @description 配置更新
 * @author wangjing
 * @date 2021/4/8 22:43
 * @version v1.0.0
 */
public class ConfigUpdater {

    private ActiveKeyValueStore activeKeyValueStore;

    private Random random = new Random();

    public static final String PATH = "/config";

    public ConfigUpdater() {
        this.activeKeyValueStore = new ActiveKeyValueStore();
        activeKeyValueStore.connect();
    }

    public void run () {
        while (true) {
            String value = random.nextInt(100) + "";
            activeKeyValueStore.write(PATH, value);
            System.out.println("set " + PATH + "to" + value);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConfigUpdater configUpdater = new ConfigUpdater();
        configUpdater.run();
    }
}
