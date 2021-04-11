/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.Rotate
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;

/**
 * Rotate
 *
 * @description 旋转数组
 * @author wangjing
 * @date 2021/4/10 14:12
 * @version v1.0.0
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] rotatedNum = new int[nums.length];
        int i = 0;
        for (int j = nums.length - k; j < nums.length; j++) {
            rotatedNum[i++] = nums[j];
        }
        for (int i1 = 0; i1 <= nums.length -1 -k; i1++) {
            rotatedNum[i++] = nums[i1];
        }
        for (int i1 = 0; i1 < rotatedNum.length; i1++) {
            nums[i1] = rotatedNum[i1];
        }
    }

    public void rotate2(int[] nums, int k) {
       reverse(nums, 0, nums.length - 1);
       reverse(nums, 0 , k -1);
       reverse(nums, k, nums.length -1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp =  nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new Rotate().rotate(new int[]{7,1,2,3,4,5,6}, 3);
    }
}
