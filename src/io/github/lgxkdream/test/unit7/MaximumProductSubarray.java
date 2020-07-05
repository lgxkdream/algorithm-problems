package io.github.lgxkdream.test.unit7;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 乘积最大子数组
 * @description https://leetcode-cn.com/problems/maximum-product-subarray/
 * @since 2020-05-18 10:06
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        /**
         * 输出: 6
         * 解释: 子数组 [2,3] 有最大乘积 6。
         */
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));

        /**
         * 输出: 0
         * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
         */
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    /**
     * 2 2 2
     * 6 3 6
     * -2 -12 6
     * 4 -48 6
     * 6
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int result = nums[0], maxProduct = 1, minProduct = 1;
        for (int num : nums) {
            if (num < 0) {
                maxProduct = maxProduct + minProduct - (minProduct = maxProduct);
            }
            maxProduct = Math.max(num, maxProduct * num);
            minProduct = Math.min(num, minProduct * num);
            result = Math.max(result, maxProduct);
            System.out.println(maxProduct + " " + minProduct + " " + result);
        }
        return result;
    }

}
