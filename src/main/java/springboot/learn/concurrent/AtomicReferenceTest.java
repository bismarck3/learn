/**
 * @projectName springbootTest
 * @package springboot.learn.concurrent
 * @className springboot.learn.concurrent.AtomicReferenceTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicReferenceTest
 *
 * @description 原子引用类
 * @author wangjing
 * @date 2020/7/30 15:24
 * @version v1.0.0
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        stamped();
    }

    private static void stamped(){
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("hello", 0);
        reference.set("test", 1);
        reference.compareAndSet("test", "hello2", 1, 2);
        reference.compareAndSet("hello2", "hello3", 1, 2);
        System.out.println(reference.getStamp());
        System.out.println(reference.getReference());
    }

    private static void reference() {
        AtomicReference<String> reference = new AtomicReference<>();
        reference.set("hello");
        reference.compareAndSet("hello1", "test");
        System.out.println(reference);
    }
}
