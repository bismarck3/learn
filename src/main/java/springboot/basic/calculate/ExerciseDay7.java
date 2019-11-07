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

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

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

        long start = System.currentTimeMillis();
        CalculatorThead thread = new CalculatorThead(1, 20000);
        CalculatorThead thread2 = new CalculatorThead(20001,40000);
        CalculatorThead thread3 = new CalculatorThead(40001,60000);
        CalculatorThead thread4 = new CalculatorThead(60001,80000);
        CalculatorThead thread5 = new CalculatorThead(80001,100000);

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

        System.out.println(result);
        String resultString = result.toString();
        char[] chars = resultString.toCharArray();
        int charsSum = 0;
        for (char c : chars) {
            charsSum += c-'0';
        }

        System.out.println(charsSum);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
    }

    static void producerAndConsumer(){
        Production production = new Production(20, 0, new Object());
        Consumer consumerRunnable = new Consumer(production);
        Producer producerRunnable = new Producer(production);

        for(int i = 0; i < 5; i++){
            Thread consumer = new Thread(consumerRunnable, "消费者线程"+i);
            consumer.start();
        }

        for(int i =0; i < 5; i++){
            Thread producer = new Thread(producerRunnable, "生产者线程"+i);
            producer.start();
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