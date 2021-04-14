/**
 * @projectName springbootTest
 * @package springboot.write.dynamic
 * @className springboot.write.dynamic.ClimbStairs
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.dynamic;
/**
 * ClimbStairs
 *
 * @description 爬楼梯
 * @author wangjing
 * @date 2021/4/11 21:37
 * @version v1.0.0
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n ==1 ) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        return climbStairs(n -1) + climbStairs(n-2);
    }

    public int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int[] temp = new int[n+1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i < temp.length; i++) {
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs2(1));
    }
}
