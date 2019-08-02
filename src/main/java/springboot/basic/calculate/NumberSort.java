/**
 * @projectName springbootTest
 * @package springboot.basic.calculate
 * @className springboot.basic.calculate.NumberSort
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package springboot.basic.calculate;

import java.util.Arrays;

/**
 * NumberSort
 *
 * @description 数字排序
 * @author wangjing
 * @date 2019/8/2 10:56
 * @version v1.0.0
 */
public class NumberSort {

    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                // 找到最小的数
                if (array[j] < array[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        if (array.length == 0){
            return array;
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2){
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length){
                result[index] = right[j++];
            }
            else if (j >= right.length){
                result[index] = left[i++];
            }
            else if (left[i] > right[j]){
                result[index] = right[j++];
            }
            else{
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end){
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start){
            quickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end){
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++){
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex){
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
