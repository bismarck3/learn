/**
 * @projectName springbootTest
 * @package springboot.learn.complatefuture
 * @className springboot.learn.complatefuture.Main
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.complatefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Main
 *
 * @description 测试
 * @author wangjing
 * @date 2019/12/2 15:30
 * @version v1.0.0
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        runAsync();
//        supplyAsync();
//        then();
//        thenCombine();
//        exceptionally();
        whenComplete();
//        handle();
    }

    static void handle() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            //出现异常
//            if (1 == 1) {
//                throw new RuntimeException("测试一下异常情况");
//            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        System.out.println(result);
    }


    static void whenComplete() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (1 == 1) {
//                throw new RuntimeException("测试一下异常情况");
//            }
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            if(t != null){
                System.out.println(t.getMessage());
            }
        })
//            .exceptionally(e -> {
//            System.out.println(e.getMessage());
//            return "hello world";
//        })
            .join();
        System.out.println(result);
    }

    static void exceptionally() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }


    static void thenCombine(){
        long start = System.currentTimeMillis();
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread1");
                Thread.sleep(3000);
                System.out.println("thread1执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread2");
                Thread.sleep(3000);
                System.out.println("thread2执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }), (s1, s2) -> {
            System.out.println(s1 + s2);
            return s1+s2;
        }).thenAccept(System.out::println).join();
        long end = System.currentTimeMillis();
        System.out.println("执行完毕\t："+(end-start));
    }

    static void then() throws InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread1");
                Thread.sleep(3000);
                System.out.println("thread1执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenApplyAsync(a -> {
            try {
                System.out.println("thread2");
                Thread.sleep(3000);
                System.out.println("thread2执行完毕\t:"+a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ++a;
        }).thenAccept(System.out::println);
        long end = System.currentTimeMillis();
        Thread.sleep(100);
        System.out.println("执行完毕\t："+(end-start));
    }

    static void supplyAsync() {
        String value = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread");
                Thread.sleep(3000);
                System.out.println("thread执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "running";
        }).getNow("默认值");
        System.out.println("执行完毕\t：" + value);
    }

    static void runAsync() {
        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("thread");
                Thread.sleep(3000);
                System.out.println("thread执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).join();
        System.out.println("执行完毕");
    }

    static void anyOfAndAllOf() throws ExecutionException, InterruptedException {
        CompletableFuture.allOf(CompletableFuture.runAsync(() -> {
            try {
                System.out.println("thread1");
                Thread.sleep(1000);
                System.out.println("thread1执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), CompletableFuture.runAsync(() -> {
            try {
                System.out.println("thread2");
                Thread.sleep(5000);
                System.out.println("thread2执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).get();
        System.out.println("所有线程执行完毕");
    }

}
