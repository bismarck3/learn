/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.ExerciseDay7
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import springboot.basic.calculate.sync.ThreadRunCount;
import springboot.basic.calculate.sync.ThreadRunCountSynchro;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * ExerciseDay7
 *
 * @description 练习7
 * @author wangjing
 * @date 2019/8/16 11:43
 * @version V1.0.0
 */
public class ExerciseDay7 {

    static void calculateFactorial() throws InterruptedException {
        long start = System.currentTimeMillis();

        int[] numbers = {0, 10000, 20000, 30000, 40000, 50000};
        BigInteger result = new BigInteger(1+"");
        for (int i = 0; i < numbers.length-1; i++) {
            CalculatorThead thread = new CalculatorThead(numbers[i]+1, numbers[i+1]);
            thread.start();
            thread.join();
            result = result.multiply(thread.getResult());
        }
        char[] chars = result.toString().toCharArray();
        int charsSum = 0;
        for (char c : chars) {
            charsSum += c-'0';
        }
        System.out.println(charsSum);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static void producerAndConsumer(){
        Production production = new Production(20);
        Consumer consumerRunnable = new Consumer(production);
        Consumer consumerRunnable2 = new Consumer(production);
        Consumer consumerRunnable3 = new Consumer(production);
        Consumer consumerRunnable4 = new Consumer(production);
        Consumer consumerRunnable5 = new Consumer(production);
        Producer producerRunnable = new Producer(production);
        Producer producerRunnable2 = new Producer(production);
        Producer producerRunnable3 = new Producer(production);
        Producer producerRunnable4 = new Producer(production);
        Producer producerRunnable5 = new Producer(production);
        Thread consumer = new Thread(consumerRunnable);
        Thread consumer2 = new Thread(consumerRunnable2);
        Thread consumer3 = new Thread(consumerRunnable3);
        Thread consumer4 = new Thread(consumerRunnable4);
        Thread consumer5 = new Thread(consumerRunnable5);


        Thread producer = new Thread(producerRunnable);
        Thread producer2 = new Thread(producerRunnable2);
        Thread producer3 = new Thread(producerRunnable3);
        Thread producer4 = new Thread(producerRunnable4);
        Thread producer5 = new Thread(producerRunnable5);

        consumer.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();

        producer.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
    }

    static void runMainAndSub(){
        final ThreadRunCount f2 = new ThreadRunCountSynchro();

        // 子线程循环3次
        new Thread(() -> {
            for(int i=0;i<3;i++){
                f2.subFunction();
            }
        }).start();

        // 主线程循环3次
        for(int i=0;i<3;i++){
            f2.mainFunction();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        calculateFactorial();
    }

}

class Consumer implements Runnable{

    private Production production;

    public Consumer(Production production) {
        this.production = production;
    }

    @Override public void run() {
        production.consumer();
    }
}

class Producer implements Runnable{

    private Production production;

    public Producer(Production production) {
        this.production = production;
    }

    @Override public void run() {
        production.produce();
    }
}



class CalculatorThead extends Thread{

    private int start;

    private int end;

    private volatile BigInteger result = new BigInteger(1+"");

    public CalculatorThead(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public BigInteger getResult() {
        return result;
    }


    @Override public void run() {
        while(start <= end){
            result = result.multiply(new BigInteger(start+""));
            start++;
        }
    }
}