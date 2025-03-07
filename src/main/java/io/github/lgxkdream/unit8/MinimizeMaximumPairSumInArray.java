package io.github.lgxkdream.unit8;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1877. 数组中最大数对和的最小值
 * @description https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
 * @since 2021-07-20 21:44
 */
public class MinimizeMaximumPairSumInArray {

    public static void main(String[] args) {
        /**
         * 输出：7
         * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
         * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
         */
        System.out.println(minPairSum(new int[]{3, 5, 2, 3}));
        /**
         * 输出：8
         * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
         * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
         */
        System.out.println(minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }

    public static int minPairSum(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len / 2; i++) {
            res = Math.max(res, nums[i] + nums[len - 1 - i]);
        }
        return res;
    }

}
