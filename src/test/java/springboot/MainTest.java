package springboot;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();
        
        /** 计算出结果sum **/
        // 获取参数
        Integer inputNumber = Integer.valueOf(args[0]);
//        Integer inputNumber = 50000;
        // 每个线程执行完，获取的结果
        BigInteger sumTemp = new BigInteger(String.valueOf(1));
        // 分片数组
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        // 分为10片
        Integer cpuSize = 10;
        Integer bc;
        if(inputNumber > cpuSize) {
            bc = inputNumber/cpuSize;
        }else {
            bc = inputNumber;
        }
        for(int i = 1 ; i <= inputNumber/bc ; i ++) {
            numbers.add(bc*i);
        }
        // 处理奇数导致分片有剩余, 奇数为11片
        if(inputNumber % 2 != 0) {
            numbers.add(inputNumber);
        }
        
        // 初始化线程池
        ExecutorService exec1 = Executors.newFixedThreadPool(numbers.size()-1);
        
        BigInteger sum = new BigInteger(String.valueOf(1));
        // 线程数量
        for( int p = 0 ; p <  numbers.size()-1; p++) {
            final int pNumber = p;
            // 每个线程利用自己的数组片进行计算
            Callable<BigInteger> thread = () -> {
                BigInteger sumThis = new BigInteger(String.valueOf(1));
                int i = numbers.get(pNumber)+1;
                for(; i <= numbers.get(pNumber+1); i++) {
                    sumThis = sumThis.multiply(new BigInteger(String.valueOf(i)));
                }
                // 计算的结果
                return sumThis;
            };
            // 获取每次线程计算的值
            sumTemp = exec1.submit(thread).get();
            // 每个线程的值累乘
            sum = sum.multiply(sumTemp);
        }
        
        
        Long end1 = System.currentTimeMillis();
        System.out.println("计算时间1：" + (end1 - start));
        
       
        Integer stringSum = 0;
        /** 结果集取每个字符相加得结果 **/
        char[] s = sum.toString().toCharArray();
        for(int k = 0 ; k < s.length ; k++) {
            stringSum = stringSum + (s[k]-'0');
        }
        
        /** 优化累加 **/
//        Integer size = sum.toString().length();
//        String sumString = sum.toString();
//        List<Integer> charNumbers = new ArrayList<>();
//        charNumbers.add(0);
//        Integer cupSize2 = 100000;
//        Integer charBc = size/cupSize2;
//        int i = 1;
//        for( ; i <=  charBc; i++) {
//            charNumbers.add(i*cupSize2);
//        }
//        i = i-1;
//        // 10000分为一组
//        charNumbers.add(i*cupSize2+size % cupSize2);
//        
//        
//        List<String> stringList = new ArrayList<>();
//        int charNumberSize = charNumbers.size();
//        for (int l = 0 ; l < charNumberSize-1 ; l++) {
//            Integer startIndex = charNumbers.get(l);
//            Integer endIndex = charNumbers.get(l+1);
//            stringList.add(sumString.substring(startIndex, endIndex));
//        }
//
//        ExecutorService exec2 = Executors.newFixedThreadPool(stringList.size()-1);
//        
//        for (String string : stringList) {
//            Integer charSum = 0;
//            Callable<Integer> thread = () -> {
//                Integer sumS = 0;
//                char[] tempChars = string.toCharArray();
//                for(int k = 0; k < tempChars.length; k++) {
//                    sumS = sumS + (tempChars[k]-'0');
//                }
//                // 计算的结果
//                return sumS;
//            };
//            // 获取每次线程计算的值
//            charSum = exec2.submit(thread).get();
//            // 每个线程的值累加
//            stringSum = stringSum + charSum;
//        }
        
        /** 优化累加结束 **/
        
        Long end2 = System.currentTimeMillis();
        exec1.shutdown();
//        exec2.shutdown();
        
        System.out.println(stringSum);
        System.out.println("计算时间2：" + (end2 - start));
    }
    
    
}
