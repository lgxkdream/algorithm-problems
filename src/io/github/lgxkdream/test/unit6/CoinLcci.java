package io.github.lgxkdream.test.unit6;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 面试题 08.11. 硬币
 * @description https://leetcode-cn.com/problems/coin-lcci/
 * @since 2020-04-23 10:02
 */
public class CoinLcci {

    // https://leetcode-cn.com/problems/coin-lcci/solution/java-wan-quan-bei-bao-xiang-xi-ti-jie-yu-yi-bu-bu-/
    public static void main(String[] args) {
        System.out.println(waysToChange1(5)); // 2
        System.out.println(waysToChange1(10)); // 4
    }

    public static int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] coins = new int[]{1, 5, 10, 25};
        for (int i = 1; i < 5; i++) {
            for (int j = coins[i - 1]; j < n + 1; j++) {
                dp[j] = (dp[j] + dp[j - coins[i - 1]]) % 1000000007;
            }
        }
        return dp[n];
    }

    // public static int waysToChange1(int n) {
    //     int[][] dp = new int[5][n + 1];
    //     for (int i = 1; i < 5; i++) {
    //         dp[i][0] = 1;
    //     }
    //     int[] coins = new int[]{1, 5, 10, 25};
    //     for (int i = 1; i < 5; i++) {
    //         for (int j = coins[i - 1]; j < n + 1; j++) {
    //             dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i - 1]]) % 1000000007;
    //             System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
    //         }
    //     }
    //     return dp[4][n];
    // }

    public static int waysToChange1(int n) {
        int[][] dp = new int[5][n + 1];
        for (int i = 1; i < 5; i++) {
            dp[i][0] = 1;
        }
        int[] coin = {1, 5, 10, 25};
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (coin[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coin[i - 1]]) % 1000000007;
                }
                System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
            }
        }
        return dp[4][n];
    }

    // 动态规划，每次小循环只用一种硬币。
    //
    // 若在一次for循环中处理四种情况(一个for里带四个硬币的处理情况)，每次计算新一项时，由于每次取的硬币是任意的，
    // 会出现对于不同的硬币取法，情况重复的现象。 例如：n=15时，res[15] = 1(全1) + res[15 - 5] + res[15 - 10] = 7，
    // 但10 + 5和5 + 10是重复的。
    //
    // 每次小循环只用一种硬币可以避免重复，因为每次小循环中选用的硬币是固定的，在没有到对应硬币的循环前，
    // 表内记录对应的解必然不包含该硬币。 例如：n=15时，四次：res[15]=0 -> res[15] = 0 -> res[15] = 2 -> res[15] = 6
    //
    // 实际上coins数组升序也不会影响结果。

    private static final int mod = 1000000007;
    private static final int[] coins = {25, 10, 5, 1};

    public static int waysToChange2(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                res[i] = (res[i] + res[i - coin]) % mod;
            }
        }
        return res[n];
    }

}
