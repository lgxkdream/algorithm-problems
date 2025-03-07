package io.github.lgxkdream.test.unit7;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 只出现一次的数字
 * @description https://leetcode-cn.com/problems/single-number/
 * @since 2020-05-14 10:06
 */
public class SingleuNmber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1})); // 1
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2})); // 4
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
