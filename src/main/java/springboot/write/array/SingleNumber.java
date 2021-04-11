/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.SingleNumber
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;
/**
 * SingleNumber
 *
 * @description 只出现一次的数字，使用异或
 * @author wangjing
 * @date 2021/4/10 12:36
 * @version v1.0.0
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2, 2, 1}));
    }
}
