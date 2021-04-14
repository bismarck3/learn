/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.ContainDuplicate
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;

import java.util.Arrays;

/**
 * ContainDuplicate
 *
 * @description 存在重复元素
 * @author wangjing
 * @date 2021/4/10 14:31
 * @version v1.0.0
 */
public class ContainDuplicate {

    public boolean containsDuplicate(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainDuplicate().
            containsDuplicate(new int[] {1,2,3,1}));
    }
}
