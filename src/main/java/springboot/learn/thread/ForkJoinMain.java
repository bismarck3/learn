/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.ForKJoinMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.math.BigDecimal;
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
public class ForkJoinMain extends RecursiveTask<BigDecimal> {

    private static final int THRESHOLD = 10000;

    private final long start;

    private final long end;

    public ForkJoinMain(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected BigDecimal compute() {
        BigDecimal sum = BigDecimal.ONE;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum = sum.multiply(new BigDecimal(i));
            }
        } else {
            long step = (start + end ) / 100;
            ArrayList<ForkJoinMain> subTasks = new ArrayList<>();
            long pos = start;
            for(int i = 1; i <= 100; i++){
                long lastOne = pos + step;
                if(lastOne > end){
                    lastOne = end;
                }
                ForkJoinMain forkJoinMain = new ForkJoinMain(pos, lastOne);
                pos+=step+1;
                subTasks.add(forkJoinMain);
                forkJoinMain.fork();
            }
            for (ForkJoinMain subTask : subTasks) {
                sum = sum.multiply(subTask.join());
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinMain forkJoinMain = new ForkJoinMain(1, 50000);
        ForkJoinTask<BigDecimal> longForkJoinTask = forkJoinPool.submit(forkJoinMain);
        BigDecimal number = longForkJoinTask.get();
        int charsSum = 0;
        for (char c : number.toString().toCharArray()) {
            charsSum += c - '0';
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(charsSum);
    }
}
