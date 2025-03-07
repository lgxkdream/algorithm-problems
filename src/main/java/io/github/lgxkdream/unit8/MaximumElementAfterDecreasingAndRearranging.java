package io.github.lgxkdream.unit8;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1846. 减小和重新排列数组后的最大元素
 * @description https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
 * @since 7/15/21 11:10 PM
 */
public class MaximumElementAfterDecreasingAndRearranging {

    public static void main(String[] args) {
        /**
         * 输出：2
         * 解释：
         * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
         * arr 中最大元素为 2 。
         */
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
        /**
         * 输出：3
         * 解释：
         * 一个可行的方案如下：
         * 1. 重新排列 arr 得到 [1,100,1000] 。
         * 2. 将第二个元素减小为 2 。
         * 3. 将第三个元素减小为 3 。
         * 现在 arr = [1,2,3] ，满足所有条件。
         * arr 中最大元素为 3 。
         */
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
        /**
         * 输出：5
         * 解释：数组已经满足所有条件，最大元素为 5 。
         */
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }

}
