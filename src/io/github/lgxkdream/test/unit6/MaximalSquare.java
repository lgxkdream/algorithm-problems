package io.github.lgxkdream.test.unit6;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 最大正方形
 * @description https://leetcode-cn.com/problems/maximal-square/
 * @since 2020-05-08 10:46
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix)); // 4
    }

    /**
     * 动态规划思想
     * dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1;
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        //  dp(i,j) 表示以 (i,j) 为右下角，且只包含 1 的正方形的边长最大值
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果该位置的值是 0，则dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 如果 i 和 j 中至少有一个为 0，则以位置 (i,j)(i,j) 为右下角的最大正方形的边长只能是 1
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 更新最大边长
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

}
