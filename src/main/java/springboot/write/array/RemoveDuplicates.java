/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.RemoveDuplicates
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;
/**
 * RemoveDuplicates
 *
 * @description 原地删除重复的数字——双指针
 * @author wangjing
 * @date 2021/4/10 13:09
 * @version v1.0.0
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[left] != nums[i]) {
                left++;
                nums[left] = nums[i];
            }
        }
        return ++left;
    }
}
