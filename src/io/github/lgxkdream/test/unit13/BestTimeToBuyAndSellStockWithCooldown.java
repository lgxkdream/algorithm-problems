package io.github.lgxkdream.test.unit13;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 309. 最佳买卖股票时机含冷冻期
 * @description https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @since 2020-07-10 21:58
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        /**
         * 输出: 3
         * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
         */
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    /**
     * 动态规划思想
     * 第 i 天结束之后的状态（i从0开始）
     * 持有股票的最大收益 dp[i][0] =
     * 不持有股票处于冷冻期的最大收益 dp[i][1] =
     * 不持有股票未处于冷冻期的最大收益 dp[i][2] =
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }

}
