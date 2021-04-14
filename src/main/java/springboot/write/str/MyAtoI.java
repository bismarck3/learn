/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.MyAtoi
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;

import java.math.BigDecimal;

/**
 * MyAtoi
 *
 * @description 字符串转换整数
 * @author wangjing
 * @date 2021/4/11 15:21
 * @version v1.0.0
 */
public class MyAtoI {

    public int myAtoI(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int sign = 1;
        int result = 0;
        int index = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = s.charAt(index++) == '+' ? 1 : -1;
        }
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit > 9 || digit < 0) {
                break;
            }
            int temp = result * 10 + digit;
            if (temp /10 != result) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = temp;
            index++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoI().myAtoI("42"));
    }
}
