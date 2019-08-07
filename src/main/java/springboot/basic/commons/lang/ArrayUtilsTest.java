/**
 * @projectName springbootTest
 * @package springboot.basic.commons.lang
 * @className springboot.basic.commons.lang.ArrayUtilsTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.commons.lang;

import org.apache.commons.lang.ArrayUtils;

import java.util.List;

/**
 * ArrayUtilsTest
 *
 * @description 数据工具类测试
 * @author wangjing
 * @date 2019/8/5 15:26
 * @version v1.0.0
 */
public class ArrayUtilsTest {

    private static int[] number1 = new int[]{1,2,3,4,5,6,7,8,9};

    private static int[] number2 = new int[]{1,2,3,4,5,6,7,8,9};

    static void print(Object obj){
        System.out.println(obj);
    }

    static void testAdd(){
        int[] numberAdd10 = ArrayUtils.add(number1, 10);
        for(int number : numberAdd10){
            print(number);
        }

        print("-------------------------分割线--------------------");
        int[] number1JoinNumber2 = ArrayUtils.addAll(number1, number2);
        for(int number : number1JoinNumber2){
            print(number);
        }
    }

    static void testSubArray(){
        int[] subarrayNumbers = ArrayUtils.subarray(number1, 1, 2);
        for(int number : subarrayNumbers){
            print(number);
        }
    }

    public static void main(String[] args) {
        testSubArray();
    }
}
