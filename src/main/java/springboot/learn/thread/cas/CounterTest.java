/**
 * @projectName learn
 * @package springboot.learn.thread.cas
 * @className springboot.learn.thread.cas.CounterTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread.cas;

import java.util.concurrent.atomic.DoubleAdder;

/**
 * CounterTest
 *
 * @description 计数测试
 * @author wangjing
 * @date 2020/9/4 11:06
 * @version v1.0.0
 */
public class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        DoubleAdder doubleAdder = new DoubleAdder();

        for(int i = 0 ; i < 10 ; i++ ){
            new Thread(() -> {
                for(int j = 0 ; j < 10000; j ++){
                    doubleAdder.add(30);
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(doubleAdder.longValue());
    }
}
