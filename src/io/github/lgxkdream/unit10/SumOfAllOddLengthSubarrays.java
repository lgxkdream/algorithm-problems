package io.github.lgxkdream.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1588. 所有奇数长度子数组的和
 * @description https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * @since 8/29/21 10:40 PM
 */
public class SumOfAllOddLengthSubarrays {

    public static void main(String[] args) {
        int[] arr = null;
        System.out.println(arr[0]);
        /**
         * 输出：58
         * 解释：所有奇数长度子数组和它们的和为：
         * [1] = 1
         * [4] = 4
         * [2] = 2
         * [5] = 5
         * [3] = 3
         * [1,4,2] = 7
         * [4,2,5] = 11
         * [2,5,3] = 10
         * [1,4,2,5,3] = 15
         * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
         */
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        /**
         * 输出：3
         * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
         */
        System.out.println(sumOddLengthSubarrays(new int[]{1, 2}));
        /**
         * 输出：66
         */
        System.out.println(sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int res = 0;

        return res;
    }

}
