package io.github.lgxkdream.unit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 368. 最大整除子集
 * @description https://leetcode-cn.com/problems/largest-divisible-subset/
 * @since 2021-04-23 20:03
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        /**
         * 输出：[1,2]
         * 解释：[1,3] 也会被视为正确答案。
         */
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        /**
         * 输出：[1,2,4,8]
         */
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        /**
         * 输出：[16,8,4,2]
         */
        System.out.println(largestDivisibleSubset(new int[]{2, 4, 7, 8, 9, 12, 16, 20}));
        /**
         * 输出：[2000000000]
         */
        System.out.println(largestDivisibleSubset(new int[]{2000000000}));
        /**
         * 输出：[4,8,240]
         */
        System.out.println(largestDivisibleSubset(new int[]{4, 8, 10, 240}));
    }

    /**
     * 动态规划
     */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1, maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > maxVal) {
                continue;
            }
            if (maxSize == dp[i] && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }

}
