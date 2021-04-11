/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.ParallelSortMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ParallelSortMain
 *
 * @description 并行排序
 * @author wangjing
 * @date 2020/12/20 22:22
 * @version v1.0.0
 */
public class ParallelParitySortMain {

    private volatile static int exchangeFlag = 1;

    static class ParallelParitySortRunnable implements Runnable{

        private CountDownLatch countDownLatch;

        private int start;

        private int[] array;

        public ParallelParitySortRunnable(CountDownLatch countDownLatch, int start, int[] array) {
            this.countDownLatch = countDownLatch;
            this.start = start;
            this.array = array;
        }

        @Override
        public void run() {
            if (array[start] > array[start+1]) {
                int temp = array[start];
                array[start] = array[start+1];
                array[start+1] = temp;
                exchangeFlag = 1;
            }
            countDownLatch.countDown();
        }
    }


    public static void parityBubblingSort(int[] array) {
        //  exc用于记录是否发生交换（判断结束
        //  start用于判断是奇1，还是偶0
        int exchangeFlag =1, start = 0;
        while (exchangeFlag == 1 || start == 1) {
            exchangeFlag = 0;
            for (int i = start; i < array.length-1; i+=2) {
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    exchangeFlag = 1;
                }
            }
            start = start == 0 ? 1 : 0;
        }
    }

    public static void parallelParitySort(int[] array) throws InterruptedException {
        int start = 0;
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (exchangeFlag == 1 || start == 1){
            exchangeFlag = 0;
            CountDownLatch countDownLatch = new CountDownLatch(array.length/2 - (array.length%2== 0?start:0));
            for (int i = 0; i < array.length-1; i++) {
                executorService.submit(new ParallelParitySortRunnable(countDownLatch, start, array));
            }
            countDownLatch.await();
            start = start == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {34, 31, 21, 4, 34, 34, 1, 54, 654, 8, 87, 675, 21, 132, 42, 54, 54323};
//        parityBubblingSort(array);

        System.out.println(Arrays.toString(array));
    }
}
