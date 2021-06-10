package io.github.lgxkdream.unit7;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 518. 零钱兑换 II
 * @description https://leetcode-cn.com/problems/coin-change-2/
 * @since 6/10/21 11:14 PM
 */
public class CoinChange2 {

    public static void main(String[] args) {
        /**
         * 输出: 4
         * 解释: 有四种方式可以凑成总金额:
         * 5=5
         * 5=2+2+1
         * 5=2+1+1+1
         * 5=1+1+1+1+1
         */
        System.out.println(change(5, new int[]{1, 2, 5}));
        /**
         * 输出: 0
         * 解释: 只用面额2的硬币不能凑成总金额3。
         */
        System.out.println(change(3, new int[]{2}));
        /**
         * 输出: 1
         */
        System.out.println(change(10, new int[]{10}));
    }

    /**
     * 初始化 dp[0]=1；
     * <p>
     * 遍历 coins，对于其中的每个元素 coin，进行如下操作：
     * <p>
     * 遍历 i 从 coin 到 amount，将 dp[i−coin] 的值加到 dp[i]。
     * 最终得到 dp[amount] 的值即为答案。
     */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
