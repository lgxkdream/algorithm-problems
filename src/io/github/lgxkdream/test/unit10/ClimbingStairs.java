package io.github.lgxkdream.test.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 70. 爬楼梯
 * @description https://leetcode-cn.com/problems/climbing-stairs/
 * @since 2020-06-13 11:19
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        /**
         * 输出： 2
         * 解释： 有两种方法可以爬到楼顶。
         * 1.  1 阶 + 1 阶
         * 2.  2 阶
         */
        System.out.println(climbStairs(2));
        /**
         * 输出： 3
         * 解释： 有三种方法可以爬到楼顶。
         * 1.  1 阶 + 1 阶 + 1 阶
         * 2.  1 阶 + 2 阶
         * 3.  2 阶 + 1 阶
         */
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }

    public static int climbStairs1(int n) {
        if (n < 3) {
            return n;
        }
        int result = 0;
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
