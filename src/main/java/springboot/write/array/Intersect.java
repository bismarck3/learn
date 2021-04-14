/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.Intersect
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intersect
 *
 * @description 数组交集
 * @author wangjing
 * @date 2021/4/10 14:56
 * @version v1.0.0
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] num = new int[result.size()];
        for (int i1 = 0; i1 < result.size(); i1++) {
            num[i1] = result.get(i1);
        }
        return num;
    }

    public static void main(String[] args) {
        new Intersect().intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }
}
