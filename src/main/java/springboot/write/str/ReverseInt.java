/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.ReverseInt
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * ReverseInt
 *
 * @description 整数反转
 * @author wangjing
 * @date 2021/4/10 19:57
 * @version v1.0.0
 */
public class ReverseInt {

    public int reverse(int x) {
        int op = x > 0 ? 1 : -1;
        x = Math.abs(x);
        String numStr = new StringBuffer(String.valueOf(x)).reverse().toString();
        String maxStr = String.valueOf(Integer.MAX_VALUE);
        if (numStr.length() >= maxStr.length() && numStr.compareTo(maxStr) > 0) {
            return 0;
        }
        return Integer.parseInt(numStr) * op;
    }

    public int reverse2(int x) {
        int operation = x > 0 ? 1 : -1;
        int result = 0;
        x = Math.abs(x);
        while (x > 0) {
            result = 10 * result + x % 10;
            x /= 10;
        }
        return result * operation;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInt().reverse2(10));
    }

}
