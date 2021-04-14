/**
 * @projectName springbootTest
 * @package springboot.learn.thread
 * @className springboot.learn.thread.ParallelPipelineMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * ParallelPipelineMain
 *
 * @description 并行流水线
 * 计算：（B+C）*B/2
 * Thread0：B+C
 * Thread1：（result）*B
 * Thread2：result/2
 * @author wangjing
 * @date 2020/12/6 16:02
 * @version v1.0.0
 */
public class ParallelPipelineMain {

    static class Mgs {
        private Integer i;
        private Integer j;
        private String soutStr;
    }

    /**
     * i+j
     */
    static class Adder implements Runnable {

        private LinkedBlockingQueue<Mgs> blockingQueue = new LinkedBlockingQueue<>();

        private Multiply multiply;

        public Adder(Multiply multiply) {
            this.multiply = multiply;
        }

        public void add(Mgs mgs) {
            blockingQueue.add(mgs);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Mgs take = blockingQueue.take();
                    take.j = take.i + take.j;
                    multiply.add(take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * i * j
     */
    static class Multiply implements Runnable {

        private LinkedBlockingQueue<Mgs> blockingQueue = new LinkedBlockingQueue<>();

        private Div div;

        public Multiply(Div div) {
            this.div = div;
        }

        public void add(Mgs mgs) {
            blockingQueue.add(mgs);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Mgs take = blockingQueue.take();
                    take.i = take.i * take.j;
                    div.add(take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Div implements Runnable{

        private LinkedBlockingQueue<Mgs> blockingQueue = new LinkedBlockingQueue<>();

        public void add(Mgs mgs) {
            blockingQueue.add(mgs);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Mgs take = blockingQueue.take();
                    take.i = take.i / 2;
                    System.out.println(take.soutStr + "=" + take.i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Div div = new Div();
        Multiply multiply = new Multiply(div);
        Adder adder = new Adder(multiply);
        new Thread(adder).start();
        new Thread(multiply).start();
        new Thread(div).start();

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                Mgs mgs = new Mgs();
                mgs.i = i;
                mgs.j = j;
                mgs.soutStr = "((" + i + "+" + j + ")*" + i + ")/2";
                adder.add(mgs);
            }
        }
    }
}
