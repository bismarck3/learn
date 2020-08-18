/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.ForKJoinMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForKJoinMain
 *
 * @description forkjoin测试
 * @author wangjing
 * @date 2020/8/18 23:14
 * @version v1.0.0
 */
public class ForKJoinMain extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10000;

    private long start;

    private long end;

    public ForKJoinMain(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            long step = (start + end ) / 100;
            ArrayList<ForKJoinMain> subTasks = new ArrayList<>();
            long pos = start;
            for(int i = 0; i < 100; i++){
                long lastOne = pos + step;
                if(lastOne > end){
                    lastOne = end;
                }
                ForKJoinMain forKJoinMain = new ForKJoinMain(pos, lastOne);
                pos+=step+1;
                subTasks.add(forKJoinMain);
                forKJoinMain.fork();
            }
            for (ForKJoinMain subTask : subTasks) {
                sum += subTask.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForKJoinMain forKJoinMain = new ForKJoinMain(0, 200000L);
        ForkJoinTask<Long> longForkJoinTask = forkJoinPool.submit(forKJoinMain);
        Long number = longForkJoinTask.get();
        System.out.println(number);
    }
}
