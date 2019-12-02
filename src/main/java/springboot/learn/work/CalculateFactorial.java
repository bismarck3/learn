package springboot.learn.work;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CalculateFactorial {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();
        Integer inputNumber = 50000;
        Integer cpuSize = 14;
        List<Integer> numbers = getSplitNumbers(inputNumber, cpuSize);
        ExecutorService exec = new ThreadPoolExecutor(numbers.size()-1, numbers.size()-1,
            0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(2), new MyCalculateThreadFactory());
        BigInteger sum = new BigInteger(String.valueOf(1));
        for( int p = 0 ; p <  numbers.size()-1; p++) {
            sum = calculateOneNumber(numbers, exec, sum, p);
        }
        Integer stringSum  = calculateNumberSum(sum);
        exec.shutdown();
        System.out.println(stringSum);
        Long end2 = System.currentTimeMillis();
        System.out.println(end2 - start);
    }

    private static BigInteger calculateOneNumber(List<Integer> numbers, ExecutorService exec, BigInteger sum, int p)
        throws InterruptedException, ExecutionException {
        BigInteger sumTemp;
        final int pNumber = p;
        Callable<BigInteger> thread = () -> {
            BigInteger sumThis = new BigInteger(String.valueOf(1));
            int i = numbers.get(pNumber)+1;
            for(; i <= numbers.get(pNumber+1); i++) {
                sumThis = sumThis.multiply(new BigInteger(String.valueOf(i)));
            }
            return sumThis;
        };
        sumTemp = exec.submit(thread).get();
        sum = sum.multiply(sumTemp);
        return sum;
    }

    private static List<Integer> getSplitNumbers(Integer inputNumber, Integer cpuSize) {
        List<Integer> numbers = new ArrayList<>(Collections.singletonList(1));
        Integer bc;
        bc = inputNumber/cpuSize;
        for(int i = 1 ; i <= inputNumber/bc ; i ++) {
            numbers.add(bc*i);
        }
        numbers.add(inputNumber);
        return numbers;
    }

    private static Integer calculateNumberSum(BigInteger sum) {
        int stringSum = 0;
        char[] s = sum.toString().toCharArray();
        for(int i = 0 ; i < s.length ; i++) {
            stringSum = stringSum + (s[i]-'0');
        }
        return stringSum;
    }

}

class MyCalculateThreadFactory implements ThreadFactory{

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "my-calculate-thread-" + mThreadNum.getAndIncrement());
    }

}