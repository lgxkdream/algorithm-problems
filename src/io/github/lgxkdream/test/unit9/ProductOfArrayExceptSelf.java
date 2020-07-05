package io.github.lgxkdream.test.unit9;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 除自身以外数组的乘积
 * @description https://leetcode-cn.com/problems/product-of-array-except-self/
 * @since 2020-06-04 21:36
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        /**
         * 输出: [24,12,8,6]
         */
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));

    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // 右侧乘积
        int[] rightProducts = new int[length];
        rightProducts[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        int[] result = new int[length];
        // 左侧乘积
        int leftProduct = 1;
        for (int i = 0; i < length; i++) {
            result[i] = leftProduct * rightProducts[i];
            leftProduct = leftProduct * nums[i];
        }
        return result;
    }

}
