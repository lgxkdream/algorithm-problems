package io.github.lgxkdream.unit6;

import java.util.PriorityQueue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1738. 找出第 K 大的异或坐标值
 * @description https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 * @since 2021-05-19 21:45
 */
public class FindKthLargestXorCoordinateValue {

    public static void main(String[] args) {
        /**
         * 输出：7
         * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        /**
         * 输出：5
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        /**
         * 输出：4
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
        /**
         * 输出：0
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));
    }

    /**
     * 动态规划+优先队列
     */
    public static int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] ^ dp[i][j - 1] ^ dp[i - 1][j] ^ matrix[i - 1][j - 1];
                queue.add(dp[i][j]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

}
