/**
 * @projectName learn
 * @package springboot.learn.complatefuture
 * @className springboot.learn.complatefuture.ExecutorCompletionServiceMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.complatefuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * ExecutorCompletionServiceMain
 *
 * @description executorComplection测试
 * @author wangjing
 * @date 2020/12/30 20:28
 * @version v1.0.0
 */
public class ExecutorCompletionServiceMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(service);
        for (int i = 0; i < 10; i++) {
            completionService.submit(new MyFuture());
        }
        for (int i = 0; i < 10; i++) {
            Future<String> future = completionService.take();
            System.out.println(future.get());
        }
    }

    static class MyFuture implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return Thread.currentThread().getName();
        }
    }
}
