/**
 * @projectName springbootTest
 * @package springboot.basic.commons.collection
 * @className springboot.basic.commons.collection.CollectionUtilsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.collection;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.list.FixedSizeList;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * CollectionUtilsTest
 *
 * @description 集合工具类测试
 * @author wangjing
 * @date 2019/8/5 18:34
 * @version v1.0.0
 */
public class CollectionUtilsTest {

    private static Character[] chars = new Character[]{'a','b','c','d','e','f','g','h','i','j','k'};
    private static Integer[] integers = new Integer[]{10,11,12,13,14,15,16,17,18,19,20,10,10,11};
    private static List<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,1,2,1));
    private static Set<Integer> numberSet = new HashSet<>(numberList);
    private static Map<Integer, String> numberMap = new HashMap<>();
    static {
        {
            numberMap.put(1, "A"); numberMap.put(2, "B"); numberMap.put(3, "C"); numberMap.put(4, "D");
            numberMap.put(5, "E"); numberMap.put(6, "F"); numberMap.put(7, "G"); numberMap.put(8, "H");
            numberMap.put(9, "I");
        }
    }


    public static void testCardinalityMap(){
        Map<Integer, Integer> cardinalityMap = CollectionUtils.getCardinalityMap(numberList);
        for(Map.Entry entry : cardinalityMap.entrySet()){
            System.out.println(entry);
        }
    }

    public static void testGet(){
        System.out.println(CollectionUtils.get(numberMap, 1));
    }

    static void testTransform(){
        CollectionUtils.transform(numberSet, obj -> {
            if(obj instanceof Integer){
                return Integer.valueOf((Integer)obj + 1);
            }
            return obj;
        });
        numberSet.forEach(System.out::println);
    }

    static void testAddAll(){
        CollectionUtils.addAll(numberSet,integers);
        for (Integer integer : numberSet) {
            System.out.println(integer);
        }
    }

    static void testFilter(){
        CollectionUtils.filter(numberSet, new Predicate() {
            @Override public boolean evaluate(Object object) {
                return ((Integer)object) > 60;
            }
        });
        CollectionUtils.filter(numberSet, number -> (Integer)number > 5);
        numberSet.forEach(System.out::println);
    }

    static void testAddIgnoreNull(){
        CollectionUtils.addIgnoreNull(numberSet, null);
        numberSet.forEach(System.out::println);
    }

    static void testCollectionOperation(){
        Integer[] number1 = {1,2,3,4,5,6,7};
        Integer[] number2 = {3,4,5,8,9};
        // union
        Collection union = CollectionUtils.union(Arrays.asList(number1), Arrays.asList(number2));
        Collection intersection = CollectionUtils.intersection(Arrays.asList(number1), Arrays.asList(number2));
        Collection disjunction = CollectionUtils.disjunction(Arrays.asList(number1), Arrays.asList(number2));
        Collection subtract = CollectionUtils.subtract(Arrays.asList(number1), Arrays.asList(number2));

        System.out.println(union);
        System.out.println(intersection);
        System.out.println(disjunction);
        System.out.println(subtract);

    }

    static void testSynchronizedAndUnmodifiable(){
        Collection synchronizedCollection = CollectionUtils.synchronizedCollection(Arrays.asList(integers));
        Collection unmodifiableCollection = CollectionUtils.unmodifiableCollection(Arrays.asList(integers));
    }

    static void testCardinality(){
        System.out.println(CollectionUtils.cardinality(Integer.valueOf(10), Arrays.asList(integers)));
    }

    static void testBag(){
        Bag bag = new HashBag();
        bag.add(1);
        bag.add(1);
        bag.add(2);
        bag.add(2);
        System.out.println(bag.getCount(1));

    }

    static void testBidiMap(){
        BidiMap bidiMap = new DualHashBidiMap();
        bidiMap.put("1", "a");
        bidiMap.put("2", "b");
        System.out.println(bidiMap.getKey("a"));
        System.out.println(bidiMap.get("2"));
    }

    static void testMultiKeyMap(){
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        multiKeyMap.put("1", "1-1", "a");
        multiKeyMap.put("2", "2-1", "b");
        System.out.println(multiKeyMap.get("1","1-1"));
    }

    static void testMultiValueMap(){
        MultiValueMap multiValueMap = new MultiValueMap();
        multiValueMap.put("1", "a");
        multiValueMap.put("1", "A");
        System.out.println(multiValueMap.get("1"));

    }

    static void testHashedMap(){
        HashedMap hashedMap = new HashedMap();
        hashedMap.put("1", "a");
        hashedMap.put("2", "b");
        MapIterator mapIterator = hashedMap.mapIterator();
        while(mapIterator.hasNext()){
            mapIterator.next();
            System.out.println(mapIterator.getKey()+"："+mapIterator.getValue());
        }
    }


    public static void main(String[] args) {
        testCardinality();
    }
}
