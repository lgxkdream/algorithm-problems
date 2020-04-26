package io.github.lgxkdream.unit2;

/**
 *
 * @title: MaximumSubarray(最大子序和) https://leetcode-cn.com/problems/maximum-subarray/submissions/
 * @description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *               示例:
 *               输入: [-2,1,-3,4,-1,2,1,-5,4],
 *               输出: 6
 *               解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @Copyright: Copyright (c) 2020
 * @author Jackie Lee
 * @version 1.0.0
 * @company: lgxkdream.github.io
 * @since 2020年1月17日 下午15:59:45
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int[] nums = {-1, -3, -4, 4, -2, -1, -5, -4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));
    }

    /**
     * 解法一 动态规划（Kadane 算法）
     *
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        // 迄今为止的最大和
        int res = nums[0];
        // 前一元素位置的最大和
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                // 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
                sum += num;
            } else {
                // 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
                sum = num;
            }
            // 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 解法二 贪心算法
     *
     * @param nums
     * @return
     */
    private static int maxSubArray1(int[] nums) {
        // 当前元素位置的最大和
        int curMax = nums[0];
        // 迄今为止的最大和
        int soFarMax = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, curMax + nums[i]);
            soFarMax = Math.max(soFarMax, curMax);
        }
        return soFarMax;
    }

}
