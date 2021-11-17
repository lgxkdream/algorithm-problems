package io.github.lgxkdream.unit9;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 剑指 Offer 10- I. 斐波那契数列
 * @description
 * @since 9/4/21 10:31 PM
 */
public class Fib {

    public static void main(String[] args) {
        /**
         * 输入：n = 2
         * 输出：1
         *
         * 输入：n = 5
         * 输出：5
         */
        System.out.println(fib(2));
        System.out.println(fib(5));
        System.out.println(fib(45));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

}
