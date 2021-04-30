package io.github.lgxkdream.unit5;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 137. 只出现一次的数字 II
 * @description https://leetcode-cn.com/problems/single-number-ii/
 * @since 2021-04-30 11:50
 */
public class SingleNumberII {

    public static void main(String[] args) {
        /**
         * 输出：3
         */
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
        /**
         * 输出：99
         */
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    /**
     * 依次确定每一个二进制位
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i & 1);
            }
            if (sum % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }

}
