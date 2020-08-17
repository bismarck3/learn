/**
 * @projectName learn
 * @package springboot.learn.map
 * @className springboot.learn.map.HashMapTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.map;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMapTest
 *
 * @description hashMap测试
 * @author wangjing
 * @date 2020/8/13 14:10
 * @version v1.0.0
 */
public class HashMapTest {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int hash(Object key) {
        int h = key.hashCode();
        return  h ^ (h >>> 16);
    }


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static void testInitPutGet(){
        Map<String, String> map = new HashMap<>(3);
        System.out.println(map.put("1", "1"));
        System.out.println(map.get("1"));
    }


    public static void main(String[] args) {
        System.out.println(0b01010101 & 16);
        System.out.println(0b10000101 & 16);

    }

}
