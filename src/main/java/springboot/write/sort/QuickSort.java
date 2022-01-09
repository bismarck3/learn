/**
 * @projectName learn
 * @package springboot.write.sort
 * @className springboot.write.sort.QuickSort
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.sort;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @description 快排
 * @author wangjing
 * @date 2021/5/13 14:16
 * @version v1.0.0
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int item = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= item && i < j) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (nums[i] <= item && i < j) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = item;
        sort(nums, left, i-1);
        sort(nums, i+1, right);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 231, 41, 34, 24, 132, 54, 1, 5};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
