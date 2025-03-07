package io.github.lgxkdream.unit6;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 231. 2 的幂
 * @description
 * @since 2021-05-30 19:27
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        /**
         * 输出：true
         * 解释：20 = 1
         */
        System.out.println(isPowerOfTwo(1));
        /**
         * 输出：true
         * 解释：24 = 16
         */
        System.out.println(isPowerOfTwo(16));
        /**
         * 输出：false
         */
        System.out.println(isPowerOfTwo(3));
        /**
         * 输出：true
         */
        System.out.println(isPowerOfTwo(4));
        /**
         * 输出：false
         */
        System.out.println(isPowerOfTwo(5));
    }

    public static boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count == 1;
    }

}
