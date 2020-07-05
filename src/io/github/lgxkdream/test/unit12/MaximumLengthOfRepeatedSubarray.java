package io.github.lgxkdream.test.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 718. 最长重复子数组
 * @description https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @since 2020-07-01 08:56
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        /**
         * 输出: 3
         * 解释:
         * 长度最长的公共子数组是 [3, 2, 1]。
         */
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    /**
     * 动态规划思想
     * dp[i][j] 表示包含A[i - 1]和B[j - 1]的A前i个字符串和B前j个字符串的最长重复子数组长度
     * dp[i][j] = when A[i] == B[j] then dp[i-1][j-1] + 1
     *
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length;
        int[][] dp = new int[aLen + 1][bLen + 1];
        int result = 0;
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

}
