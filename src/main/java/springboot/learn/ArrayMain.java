/**
 * @projectName learn
 * @package springboot.learn
 * @className springboot.learn.ArrayMain
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package springboot.learn;
/**
 * ArrayMain
 *
 * @description 数组
 * @author wangjing
 * @date 2020/11/24 14:53
 * @version v1.0.0
 */
public class ArrayMain {

    static void array1() {
        long start = System.currentTimeMillis();
        int[][] array = new int[64 * 1024][1024];

        // 横向遍历
        for(int i = 0; i < 64 * 1024; i ++) {
            for(int j = 0; j < 1024; j ++) {
                array[i][j] ++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("array1" + (end - start));
    }

    static void array2() {
        long start = System.currentTimeMillis();
        int[][] array = new int[64 * 1024][1024];
        // 纵向遍历
        for(int i = 0; i < 1024; i ++) {
            for(int j = 0; j < 64 * 1024; j ++) {
                array[j][i] ++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("array2" + (end - start));
    }

    public static void main(String[] args) {
        array1();
        array2();
    }
}
