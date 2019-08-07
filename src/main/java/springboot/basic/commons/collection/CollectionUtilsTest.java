/**
 * @projectName springbootTest
 * @package springboot.basic.commons.collection
 * @className springboot.basic.commons.collection.CollectionUtilsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.SetUtils;
import org.apache.commons.collections.Transformer;
import springboot.basic.reflect.entity.User;

import java.lang.reflect.Field;
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
    private static Integer[] integers = new Integer[]{10,11,12,13,14,15,16,17,18,19,20};
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
        CollectionUtils.filter(numberSet, number -> (Integer)number > 5);
        numberSet.forEach(System.out::println);
    }

    static void testAddIgnoreNull(){
        CollectionUtils.addIgnoreNull(numberSet, null);
        numberSet.forEach(System.out::println);
    }

    static void test(){
    }


    public static void main(String[] args) {
        testAddIgnoreNull();
    }
}
