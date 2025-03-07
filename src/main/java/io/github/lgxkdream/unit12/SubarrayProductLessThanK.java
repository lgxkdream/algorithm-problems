package io.github.lgxkdream.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 713. 乘积小于 K 的子数组
 * @description https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * @since 2022-05-05 21:13
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        /**
         * 输出：8
         * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
         * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
         */
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        /**
         * 输出：0
         */
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        /**
         * 输出：0
         */
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0, left = 0, product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left <= i && product >= k) {
                product /= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    }

}
