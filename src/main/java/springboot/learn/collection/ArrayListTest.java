/**
 * @projectName learn
 * @package springboot.learn.collection
 * @className springboot.learn.collection.ArrayListTest
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ArrayListTest
 *
 * @description list测试
 * @author wangjing
 * @date 2020/8/14 13:45
 * @version v1.0.0
 */
public class ArrayListTest {

    public static void main(String[] args) {
        testCopy();
    }

    static void testCopy(){
        int [] number1 = {1,2,3,4,5};
        int [] number2 = new int[10];
        int[] number3 = Arrays.copyOf(number1, 10);
        System.arraycopy(number1, 0, number2, 0, 5);
        number1[0] = 0;
        number3[0] = -1;
        System.out.println(number2.toString());
        System.out.println(number3.toString());
    }

    private static void common() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        System.out.println(numbers.get(0));
    }
}
