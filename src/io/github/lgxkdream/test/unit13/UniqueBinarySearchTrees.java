package io.github.lgxkdream.test.unit13;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 96. 不同的二叉搜索树
 * @description https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @since 2020-07-31 19:59
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        /**
         * 输入: 3
         * 输出: 5
         * 解释:
         * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
         *
         *    1         3     3      2      1
         *     \       /     /      / \      \
         *      3     2     1      1   3      2
         *     /     /       \                 \
         *    2     1         2                 3
         *
         */
        System.out.println(numTrees(3));
    }

    /**
     * 动态规划思想
     * dp[n] = F(i, n) i=1,2,3...n  长度为n的元素共有以i(i=1,2,3...n)为跟时的个数和
     * F(i, n) = dp[i-1] + dp[n-i]
     * <p>
     * dp[0] = dp[1] = 1;
     * dp[n] = dp[i-1] * dp[n-i] i=1,2,3...n
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
