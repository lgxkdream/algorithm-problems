package io.github.lgxkdream.test.unit2;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title CoinChange
 * @description https://leetcode-cn.com/problems/coin-change/comments/
 * https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 * @since 2020-03-23 09:39
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private static int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }











    // public int coinChange(int[] coins, int amount) {
    //     return coinChange(0, coins, amount);
    // }

    /**
     *
     * @param idxCoin 开始硬币索引
     * @param coins 硬币列表
     * @param amount 拼凑的金额
     * @return
     */
    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            // 该种硬币的最大个数
            int maxVal = amount / coins[idxCoin];
            // 最少使用个数
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }

}
