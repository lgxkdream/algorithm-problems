package io.github.lgxkdream.unit5;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 633. 平方数之和
 * @description https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @since 4/28/21 10:56 PM
 */
public class SumOfSquareNumbers {

    public static void main(String[] args) {
        /**
         * 输出：true
         * 解释：1 * 1 + 2 * 2 = 5
         */
        System.out.println(judgeSquareSum(5));
        /**
         * 输出：false
         */
        System.out.println(judgeSquareSum(3));
        /**
         * 输出：true
         */
        System.out.println(judgeSquareSum(4));
        /**
         * 输出：true
         */
        System.out.println(judgeSquareSum(2));
    }

    /**
     * 双指针思想
     */
    public static boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c) + 1;
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur == c) {
                return true;
            } else if (cur < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

}
