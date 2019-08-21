/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.ExerciseDay7
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import springboot.basic.calculate.sync.ThreadRunCount;
import springboot.basic.calculate.sync.ThreadRunCountSynchro;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * ExerciseDay7
 *
 * @description 练习7
 * @author wangjing
 * @date 2019/8/16 11:43
 * @version V1.0.0
 */
public class ExerciseDay7 {

    static void caculatorFactorial() throws InterruptedException {
        CalculatorThead thread = new CalculatorThead(1,10000);
        CalculatorThead thread2 = new CalculatorThead(10001,20000);
        CalculatorThead thread3 = new CalculatorThead(20001,30000);
        CalculatorThead thread4 = new CalculatorThead(30001,40000);
        CalculatorThead thread5 = new CalculatorThead(40001,50000);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        BigDecimal result = thread.getResult().multiply(thread2.getResult()).multiply(thread3.getResult())
            .multiply(thread4.getResult()).multiply(thread5.getResult());

        String resultString = result.toString();
        char[] chars = resultString.toCharArray();
        int charsSum = 0;
        for (char c : chars) {
            charsSum += c-'0';
        }

        System.out.println(charsSum);
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
        producerAndConsumer();
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

    private volatile BigDecimal result = new BigDecimal(1);

    public CalculatorThead(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public BigDecimal getResult() {
        return result;
    }


    @Override public void run() {
        while(start <= end){
            result = result.multiply(new BigDecimal(start));
            start++;
        }
    }
}