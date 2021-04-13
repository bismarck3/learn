/**
 * @projectName springbootTest
 * @package springboot.learn.complatefuture
 * @className springboot.learn.complatefuture.Main
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.complatefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
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
        whenComplete();
    }

    static void handle() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //出现异常
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).handle((data, throwable) -> {
            if (throwable != null) {
                return "hello world";
            }
            return "handle"+data;
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
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            if(t != null){
                System.out.println(t.getMessage());
            }
        }).join();
        System.out.println(result);
    }

    static void exceptionally() {
        exceptionllyFailure();
        System.out.println("-----------");
        exceptionallySuccess();
    }

    private static void exceptionllyFailure() {
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

    private static void exceptionallySuccess() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
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

    static void afterBoth(){
        long start = System.currentTimeMillis();
        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("thread1");
                Thread.sleep(3000);
                System.out.println("thread1执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).runAfterBoth(CompletableFuture.runAsync(() -> {
            try {
                System.out.println("thread2");
                Thread.sleep(3000);
                System.out.println("thread2执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), () ->  System.out.println("两个任务都执行完毕了"))
            .thenAccept(System.out::println).join();
        long end = System.currentTimeMillis();
        System.out.println("执行完毕\t："+(end-start));
    }

    static void then() {
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread1");
                Thread.sleep(3000);
                System.out.println("thread1执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        supplyAsync.thenApply(a -> {
            try {
                System.out.println("进入thread2");
                Thread.sleep(3000);
                System.out.println("thread2执行完毕\t:"+a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ++a;
        });
        supplyAsync.thenApply(number -> {
            try {
                System.out.println("进入thread3");
                Thread.sleep(3000);
                System.out.println("thread3执行完毕\t:"+number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ++number;
        });
        supplyAsync.thenAccept(number -> {
            try {
                System.out.println("进入thread4");
                Thread.sleep(3000);
                System.out.println("thread4执行完毕\t:"+number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        while(true){

        }
    }

    static void thenRun(){
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread1");
                Thread.sleep(3000);
                System.out.println("thread1执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        supplyAsync.thenRun(() -> {
            try {
                System.out.println("进入thread2");
                Thread.sleep(3000);
                System.out.println("thread2执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        supplyAsync.thenRun(() -> {
            try {
                System.out.println("进入thread3");
                Thread.sleep(3000);
                System.out.println("thread3执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        supplyAsync.thenRun(() -> {
            try {
                System.out.println("进入thread4");
                Thread.sleep(3000);
                System.out.println("thread4执行完毕:");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        while(true){

        }
    }

    static void supplyAsync() {
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread");
                Thread.sleep(3000);
                System.out.println("thread执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "running";
        });
        System.out.println("执行完毕");

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
        try {
            CompletableFuture.runAsync(() -> {
                try {
                    System.out.println("thread");
                    Thread.sleep(3000);
                    System.out.println("thread执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
    }

    static void anyOfAndAllOf(){
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
        })).join();
        System.out.println("所有线程执行完毕");
    }

}
