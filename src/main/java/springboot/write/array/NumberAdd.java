/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.NumerAdd
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * NumerAdd
 *
 * @description 数字相加
 * @author wangjing
 * @date 2021/4/15 21:45
 * @version v1.0.0
 */
public class NumberAdd {

    public Integer[] numberAdd(Integer[] numbers) {
        int i = numbers.length -1 ;
        for (; i >= 0; i--) {
            int number = numbers[i]+1;
            // 正常数字加
            if (number < 10) {
                numbers[i]++;
                return numbers;
            }
            // 进位
            numbers[i] = number % 10;
        }
        Integer[] temp = new Integer[numbers.length+1];
        temp[0] = 1;
        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        String next = in.next();
        char[] chars = next.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                numbers.add(aChar - '0');
            }
        }
        Integer[] format = new Integer[0];
        Integer[] resultNumbers = new NumberAdd().numberAdd(numbers.toArray(format));
        String result = "";
        for (Integer number : resultNumbers) {
            result = result + number;
            result += ",";
        }
        System.out.println(result);
    }
}
