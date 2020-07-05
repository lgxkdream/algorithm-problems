package io.github.lgxkdream.test.unit7;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Pow(x, n)
 * @description https://leetcode-cn.com/problems/powx-n/
 * @since 2020-05-11 10:05
 */
public class PowXn {

    public static void main(String[] args) {
        /**
         * 输出: 1024.00000
         */
        System.out.println(myPow1(2.00000, 10));
        /**
         * 输出: 9.26100
         */
        System.out.println(myPow1(2.10000, 3));
        /**
         * 输出: 0.25000
         * 解释: 2-2 = 1/22 = 1/4 = 0.25
         */
        System.out.println(myPow1(2.00000, -2));
    }

    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
    /**
     * x          i   res
     * 2*2=4      10  1
     * 4*4=16     5   4
     * 16*16=256  2   4
     * 256*256=   1   4*256=1024
     *
     * 2^10 = 2^2 * 2^2^2^2 = 2个2乘积 + 8个2的乘积
     */
    /**
     * x          i   res
     * 2*2=4      5   2
     * 4*4=16     2   2
     * 16*16=256  1   2*16=32
     * <p>
     * 2^5 = 2 * 2^2^2 = 1个2乘积 + 4个2的乘积
     */

    public static double myPow1(double x, int n) {
        double res = 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = n; i != 0; i >>= 1) {
            if ((i & 1) != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

}
