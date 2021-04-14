/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.ParallSearchMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.org.apache.regexp.internal.RE;

/**
 * ParallSearchMain
 *
 * @description 并行搜索
 * begin、end设定区间，分线程搜索
 * @author wangjing
 * @date 2020/12/6 16:51
 * @version v1.0.0
 */
public class ParallSearchMain {

    private static int[] array;

    private static AtomicInteger result = new AtomicInteger(-1);

    static class SearchThread implements Callable<Integer> {

        private int begin;
        private int end;
        private int searchNumber;

        public SearchThread(int begin, int end, int searchNumber) {
            this.begin = begin;
            this.end = end;
            this.searchNumber = searchNumber;
        }

        @Override
        public Integer call() throws Exception {
            return search(begin, end, searchNumber);
        }
    }

    private static int search(int begin, int end, int searchNumber) {
        int i;
        for (i = begin; i < end; i++) {
            // 如果其他线程已经找到，返回结果
            if (result.get() > 0) {
                return result.get();
            }
            // 如果找到匹配的值
            if (array[i] == searchNumber) {
                // 如果设置失败，则其他线程已经找到
                if (result.compareAndSet(-1, i)) {
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        array = new int[]{1,2,3,4,412,41,41,312,3,432,43125,15,43,51,346,6,5,46,43,2,4,3,126,4,4,43,34,4,23,432,4,135};
        int searchNumber = 4;
        int begin = 0;
        int threadSize = 5;
        int step = array.length / threadSize+1;
        int end;
        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();
        List<Future<Integer>> resultFuture = new ArrayList<>();
        for (int i = 0; i < 5; i+=step) {
            end = i + step;
            // 处理最后一段数据不够的情况
            if (end >= array.length) {
                end = array.length;
            }
            resultFuture.add(threadPoolExecutor.submit(new SearchThread(begin, end, searchNumber)));
        }

        for (Future<Integer> result : resultFuture) {
            if (result.get() > 0) {
                System.out.println(result.get());
                break;
            }
        }
    }
}
