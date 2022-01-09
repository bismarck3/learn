/**
 * @projectName springbootTest
 * @package springboot.write.array
 * @className springboot.write.array.MajorityElement
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;
/**
 * MajorityElement
 *
 * @description 多数元素(大于n/2次数的元素)
 * @author wangjing
 * @date 2021/5/12 23:17
 * @version v1.0.0
 */
public class MajorityElement {

    /**
     * 投票法
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
