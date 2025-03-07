package io.github.lgxkdream.test.unit9;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 新21点
 * @description https://leetcode-cn.com/problems/new-21-game/
 * @since 2020-06-03 09:55
 */
public class New21Game {

    /**
     * 当 <K 时抽取W   求 <=N 的概率
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 输出：1.00000
         * 说明：爱丽丝得到一张卡，然后停止。
         */
        System.out.println(new21Game(10, 1, 10));

        /**
         * 输出：0.60000
         * 说明：爱丽丝得到一张卡，然后停止。
         * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
         */
        System.out.println(new21Game(6, 1, 10));

        /**
         * 输出：0.73278
         */
        System.out.println(new21Game(21, 17, 10));

        /**
         * 输出：1.0
         */
        System.out.println(new21Game(1, 0, 1));
    }

    /**
     * 假设dp[x]手上牌面为x时，能获胜的概率
     * dp[x] = 1/W (dp[x+1] + ... + dp[x + W])
     * 两个区间 可以继续抽[0, K-1]  不可以继续抽[K, K + W -1]
     * 当[K,N]概率为1    当[N + 1, K + w -1]概率为0
     *
     * @param N 求 <=N 的概率
     * @param K 当 <K  时抽取W
     * @param W
     * @return
     */
    public static double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1;
        }
        double[] dp = new double[K + W];
        double s = 0;
        for (int i = K; i < N + 1; i++) {
            dp[i] = 1;
            s += dp[i];
        }
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = s / W;
            s = s + dp[i] - dp[i + W];
        }
        return dp[0];
    }

}
