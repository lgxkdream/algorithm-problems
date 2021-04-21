package io.github.lgxkdream.unit4;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 91. 解码方法
 * @description https://leetcode-cn.com/problems/decode-ways/
 * @since 2021-04-21 22:03
 */
public class DecodeWays {

    public static void main(String[] args) {
        /**
         * 输出：2
         * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
         */
        System.out.println(numDecodings("12"));
        /**
         * 输出：3
         * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
         */
        System.out.println(numDecodings("226"));
        /**
         * 输出：0
         * 解释：没有字符映射到以 0 开头的数字。
         * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
         * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
         */
        System.out.println(numDecodings("0"));
        /**
         * 输出：0
         * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
         */
        System.out.println(numDecodings("06"));
    }

    /**
     * 动态规划
     */
    public static int numDecodings(String s) {

    }

}
