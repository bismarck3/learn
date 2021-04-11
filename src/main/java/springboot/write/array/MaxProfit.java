/**
 * @projectName springbootTest
 * @package springboot.write
 * @className springboot.write.array.MaxProfit
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.array;
/**
 * MaxProfit
 *
 * @description 买卖股票的最佳时机，每天数值相减，然后累加
 * @author wangjing
 * @date 2021/4/10 13:38
 * @version v1.0.0
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                max += prices[i+1] - prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
