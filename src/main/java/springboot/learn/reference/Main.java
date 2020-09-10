/**
 * @projectName springbootTest
 * @package springboot.learn.reference
 * @className springboot.learn.reference.Main
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import sun.misc.GC;

/**
 * Main
 *
 * @description 引用
 * @author wangjing
 * @date 2020/7/30 15:49
 * @version v1.0.0
 */
public class Main {

    public static void main(String[] args) {
        weakReferenceInteger();
    }

    private static void weakReference(){
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> reference = new WeakReference<>(object, referenceQueue);
        object = null;
        System.gc();
        System.out.println(reference.get());
        System.out.println(referenceQueue.poll());
    }

    private static void weakReferenceInteger(){
        Integer object = 1;
        ReferenceQueue<Integer> referenceQueue = new ReferenceQueue<>();
        WeakReference<Integer> reference = new WeakReference<>(object, referenceQueue);
        object = null;
        System.gc();
        System.out.println(reference.get());
        System.out.println(referenceQueue.poll());
    }

    private static void softReference() {
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        SoftReference<Object> reference = new SoftReference<>(object, referenceQueue);
        object = null;
        System.out.println(reference.get());
        System.out.println(referenceQueue.poll());
    }

    private static void weakHashMap(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        WeakHashMap<String, Object> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(s1, "1");
        weakHashMap.put(s2, "2");
        weakHashMap.put(s3, "3");

        s1 = null;
        s2 = null;
        System.gc();
        weakHashMap.remove(s3);
        weakHashMap.entrySet().forEach(System.out::println);
    }

    private static void weakHashMapObject(){
        Number number = new Number();
        ThreadLocal<Number> numberThreadLocal = ThreadLocal.withInitial(() -> number);
        for(int i = 0 ; i < 5 ; i++){
            new Thread(() -> {
                numberThreadLocal.get().setNumber(numberThreadLocal.get().getNumber() + 5);
                System.out.println(numberThreadLocal.get().getNumber());
            }).start();
        }
    }

    private static void weakHashMapInteger(){
        Integer[] integer = {5};
        ThreadLocal<Integer[]> numberThreadLocal = ThreadLocal.withInitial(() -> integer);
        for(int i = 0 ; i < 5 ; i++){
            new Thread(() -> {
                integer[0] = integer[0] + 5;
                numberThreadLocal.set(integer);
                System.out.println(numberThreadLocal.get()[0]);
            }).start();
        }
    }

    static class Number{
        private Integer number = 0;

        /**
         * @return the number
         */
        public Integer getNumber() {
            return number;
        }

        /**
         * @param number the number to set
         */
        public void setNumber(Integer number) {
            this.number = number;
        }
    }
}
