/**
 * @projectName learn
 * @package springboot.learn.thread.cas
 * @className springboot.learn.thread.cas.CasQueue
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.thread.cas;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import sun.misc.Unsafe;

/**
 * CasQueue
 *
 * @description cas队列
 * @author wangjing
 * @date 2020/8/21 14:29
 * @version v1.0.0
 */
public class CasQueue<E> {

    private Node<E> head;

    private Node<E> tail;

    public boolean offer(E node){
        final CasQueue.Node<E> newNode = new CasQueue.Node<E>(node);
        Node<E> p = tail, t = p;
        p.casNext(null, newNode);
        return true;
    }

    private static final sun.misc.Unsafe UNSAFE;
    private static final long headOffset;
    private static final long tailOffset;
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = ConcurrentLinkedQueue.class;
            headOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("head"));
            tailOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("tail"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public Node<E> take(){
        return null;
    }

    static final class Node<E> {

        E item;

        Node<E> next;

        private static final sun.misc.Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;

        static {
            try {
                UNSAFE = sun.misc.Unsafe.getUnsafe();
                Class<?> k = CasQueue.Node.class;
                itemOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("item"));
                nextOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        Node(E item) {
            UNSAFE.putObject(this, itemOffset, item);
        }

        boolean casItem(E cmp, E val) {
            return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        boolean casNext(CasQueue.Node<E> cmp, CasQueue.Node<E> val) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }


    }

    public static void main(String[] args) {
        Queue<String> linkedQueue = new ConcurrentLinkedQueue<>();
        linkedQueue.offer("1");
        linkedQueue.offer("2");
        linkedQueue.offer("3");
    }
}
