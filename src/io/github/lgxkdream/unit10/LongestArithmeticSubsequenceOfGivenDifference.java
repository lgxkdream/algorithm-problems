package io.github.lgxkdream.unit10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1218. 最长定差子序列
 * @description https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * @since 11/5/21 10:21 PM
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args) {
        /**
         * 输出：4
         * 解释：最长的等差子序列是 [1,2,3,4]。
         */
        System.out.println(longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        /**
         * 输出：1
         * 解释：最长的等差子序列是任意单个元素。
         */
        System.out.println(longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        /**
         * 输出：4
         * 解释：最长的等差子序列是 [7,5,3,1]。
         */
        System.out.println(longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

    /**
     * 动态规划
     */
    public static int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int a : arr) {
            dp.put(a, dp.getOrDefault(a - difference, 0) + 1);
            res = Math.max(res, dp.get(a));
        }
        return res;
    }

}
