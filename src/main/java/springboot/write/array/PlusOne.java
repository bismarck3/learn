/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.PlusOne
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;

/**
 * PlusOne
 *
 * @description 数字加一
 * @author wangjing
 * @date 2021/4/10 15:13
 * @version v1.0.0
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        StringBuilder num = new StringBuilder();
        for (int digit : digits) {
            num.append(digit);
        }
        Long i = Long.parseLong(num.toString());
        i++;
        char[] chars = i.toString().toCharArray();
        int[] result = new int[chars.length];
        for (int i1 = 0; i1 < chars.length; i1++) {
            result[i1] = chars[i1] - 48;
        }
        return result;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        new PlusOne().plusOne2(new int[]{8,9,9,9});
    }
}
