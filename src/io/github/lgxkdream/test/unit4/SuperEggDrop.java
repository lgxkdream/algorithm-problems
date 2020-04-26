package io.github.lgxkdream.test.unit4;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title SuperEggDrop
 * @description https://leetcode-cn.com/problems/super-egg-drop/
 * @since 2020-04-11 11:50
 */
public class SuperEggDrop {

    public static void main(String[] args) {
        System.out.println(superEggDrop1(8, 10000)); // 14
        System.out.println(superEggDrop1(1, 2)); // 2
        System.out.println(superEggDrop1(2, 6)); // 3
        System.out.println(superEggDrop1(3, 14)); // 4
    }

    public static int superEggDrop1(int K, int N) {
        StopWatch started = StopWatch.createStarted();
        int[][] dp = new int[N + 1][K + 1];
        for (int n = 1; n <= N; n++) {
            Arrays.fill(dp[n], n);
        }
        // System.out.println(Arrays.deepToString(dp));
        for (int k = 1; k <= K; k++) {
            dp[1][k] = 1;
        }
        // for (int n = 1; n <= N; n++) {
        //     dp[n][1] = n;
        // }
        for (int n = 2; n <= N; n++) {
            for (int k = 2; k <= K; k++) {
                // dp[n][k] = n;
                for (int j = 1; j <= n; j++) {
                    dp[n][k] = Math.min(dp[n][k], Math.max(dp[j - 1][k - 1], dp[n - j][k]) + 1);
                }
            }
        }
        started.stop();
        System.out.println("耗时：" + started.getTime(TimeUnit.MILLISECONDS));
        return dp[N][K];
    }

    private static int superEggDrop(int k, int i) {
        if (k == 1) {
            return i;
        }
        if (i == 0) {
            return 0;
        }
        Integer result = Integer.MAX_VALUE;
        for (int j = 1; j <= i; j++) {
            result = Math.min(result, Math.max(superEggDrop(k, i - j), superEggDrop(k - 1, j - 1)) + 1);
        }
        return result;
    }

}
