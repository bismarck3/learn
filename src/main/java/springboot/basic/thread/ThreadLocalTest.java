/**
 * @projectName springbootTest
 * @package springboot.basic.thread
 * @className springboot.basic.thread.ThreadLocalTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.thread;

/**
 * ThreadLocalTest
 *
 * @description 本地线程测试
 * @author wangjing
 * @date 2019/8/15 16:32
 * @version v1.0.0
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        for(int i = 0 ; i < 10; i ++){
            new Thread(new FlagCheckThreadLocalRunnable()).start();
        }
    }
}

class FlagCheckThreadLocalRunnable implements Runnable{

    private ThreadLocal<Byte[]> data = new ThreadLocal<>();

    @Override public void run() {
        while(true){
            data.set(new Byte[1000]);
        }
    }
}