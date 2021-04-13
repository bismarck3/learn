/**
 * @projectName springbootTest
 * @package springboot.write.str
 * @className springboot.write.str.MySort
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.str;
/**
 * MySort
 *
 * @description 排序
 * @author wangjing
 * @date 2021/4/12 22:37
 * @version v1.0.0
 */
public class MySort {

    public int[] mySort(int[] arr) {
        quickSort(arr, 0, arr.length -1);
        return arr;
    }

    public int[] mySort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -i-1; j++) {
                if (arr[j] > arr[j +1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int t;
            int i = low, j = high, key = arr[low];
            while (i < j) {
                while (i<j && arr[j] >= key) {
                    j--;
                }
                while (i<j && arr[i] <= key) {
                    i++;
                }
                if (i < j) {
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            arr[low] = arr[i];
            arr[i] = key;
            quickSort(arr, low, i - 1);
            quickSort(arr,i+1, high);
        }
    }

    public static void main(String[] args) {
        new MySort().mySort(new int[]{3,21,4,5,1});
    }
}
