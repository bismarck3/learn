/**
 * @projectName springbootTest
 * @package springboot.learn.thread.pool
 * @className springboot.learn.thread.pool.ExceptionMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ExceptionMain
 *
 * @description 异常测试
 * @author wangjing
 * @date 2020/8/17 21:18
 * @version v1.0.0
 */
public class ExceptionMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for(int i = 0 ; i < 5 ; i++){
            Future<?> submit = threadPoolExecutor.submit(new Divide(i));
            submit.get();
        }
    }
}
class Divide implements Runnable{

    private int i;

    public Divide(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(100 / i);
    }
}
