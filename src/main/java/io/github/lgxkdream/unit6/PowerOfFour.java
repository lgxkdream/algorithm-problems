package io.github.lgxkdream.unit6;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 342. 4的幂
 * @description https://leetcode-cn.com/problems/power-of-four/
 * @since 2021-05-31 22:07
 */
public class PowerOfFour {

    public static void main(String[] args) {
        /**
         * 输出：true
         */
        System.out.println(isPowerOfFour(16));
        /**
         * 输出：false
         */
        System.out.println(isPowerOfFour(5));
        /**
         * 输出：true
         */
        System.out.println(isPowerOfFour(1));
    }

    public static boolean isPowerOfFour(int n) {
        int count = 0, index = 0, curIndex = 0;
        while (n > 0) {
            int sub = n & 1;
            if (sub == 1) {
                index = curIndex;
            }
            count += sub;
            n >>= 1;
            curIndex++;
        }
        return count == 1 && index % 2 == 0;
    }

}
