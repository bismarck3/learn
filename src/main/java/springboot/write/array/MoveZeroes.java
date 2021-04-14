/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.MoveZeroes
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;
/**
 * MoveZeroes
 *
 * @description 移动零
 * @author wangjing
 * @date 2021/4/10 15:38
 * @version v1.0.0
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换
                int temp = nums[result];
                nums[result] = nums[i];
                nums[i] = temp;
                result++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=0) {
                nums[result] = nums[i];
                result++;
            }
        }
        for (int i = result; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{1,2});
    }
}
