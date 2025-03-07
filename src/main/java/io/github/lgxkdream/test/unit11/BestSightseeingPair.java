package io.github.lgxkdream.test.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1014. 最佳观光组合
 * @description https://leetcode-cn.com/problems/best-sightseeing-pair/
 * @since 2020-06-17 10:36
 */
public class BestSightseeingPair {

    public static void main(String[] args) {
        /**
         * 输出：11
         * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
         */
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    /**
     * dp[i] = max(max(A[i-1] + (i-1)) + A[i] - i)
     *
     * @param A
     * @return
     */
    public static int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }
        int result = 0, maxLeft = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            result = Math.max(result, maxLeft + A[i] - i);
            maxLeft = Math.max(maxLeft, A[i] + i);
        }
        return result;
    }

}
