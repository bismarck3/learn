/**
 * @projectName springbootTest
 * @package springboot.write.sort
 * @className springboot.write.sort.MergeSort
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.sort;
/**
 * MergeSort
 *
 * @description 归并排序
 * @author wangjing
 * @date 2021/4/13 20:16
 * @version v1.0.0
 */
public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int left,  int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid ,int right) {
        int[] help = new int[right-left+1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=mid) {
            help[i++] = arr[p1++];
        }
        while(p2<=right) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[left+i1] = help[i1];
        }
    }

    public static void main(String[] args) {
        new MergeSort().sort(new int[] {13,12,4,43,43,54,423,1,6,65});
    }
}
