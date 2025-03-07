package io.github.lgxkdream.test.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 209. 长度最小的子数组
 * @description https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @since 2020-06-28 09:51
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        /**
         * 输出: 2
         * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
         */
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 双指针思想
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= s) {
                result = Math.min(result, r - l + 1);
                sum -= nums[l++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
