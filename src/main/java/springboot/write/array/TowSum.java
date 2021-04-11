/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.TowSum
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;

import java.util.HashMap;
import java.util.Map;

/**
 * TowSum
 *
 * @description 两数字相加
 * @author wangjing
 * @date 2021/4/10 16:25
 * @version v1.0.0
 */
public class TowSum {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        while (left < nums.length) {
            for (int i = left+1; i < nums.length; i++) {
                if (nums[left] + nums[i] == target) {
                    return new int[]{left, i};
                }
            }
            left++;
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target-nums[i], i);
        }
        int [] result = new int[0];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                result = new int[]{map.get(nums[i]), i};
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new TowSum().twoSum2(new int[]{2,5,5,11}, 10);
    }
}
