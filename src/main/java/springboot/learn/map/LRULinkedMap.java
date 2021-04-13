/**
 * @projectName learn
 * @package springboot.learn.map
 * @className springboot.learn.map.LRULinkedMap
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRULinkedMap
 *
 * @description LRU(leastRecentlyUseMap)
 * @author wangjing
 * @date 2020/11/26 14:22
 * @version v1.0.0
 */
public class LRULinkedMap<K, V> {

    private int cacheSize;

    private LinkedHashMap<K, V> cacheMap;

    public LRULinkedMap(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cacheMap = new LinkedHashMap<K, V>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cacheSize + 1 == cacheMap.size();
            }
        };
    }

    public void put(K key, V value) {
        this.cacheMap.put(key, value);
    }

    public V get(K key) {
        return this.cacheMap.get(key);
    }

    public static void main(String[] args) {
        LRULinkedMap<String, String> lruLinkedMap = new LRULinkedMap<>(5);
        lruLinkedMap.put("1", "1");
        lruLinkedMap.put("2", "1");
        lruLinkedMap.put("3", "1");
        lruLinkedMap.put("4", "1");
        lruLinkedMap.put("5", "1");
        lruLinkedMap.get("1");
        lruLinkedMap.get("2");
        lruLinkedMap.get("3");
        lruLinkedMap.get("4");
        lruLinkedMap.put("6", "6");
        System.out.println(lruLinkedMap);
    }
}
