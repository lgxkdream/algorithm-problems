package io.github.lgxkdream.unit11;

import sun.security.util.Length;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1446. 连续字符
 * @description https://leetcode-cn.com/problems/consecutive-characters/
 * @since 12/1/21 11:08 PM
 */
public class ConsecutiveCharacters {

    public static void main(String[] args) {
        /**
         * 输出：2
         * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
         */
        System.out.println(maxPower("leetcode"));
        /**
         * 输出：5
         * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
         */
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        /**
         * 输出：5
         */
        System.out.println(maxPower("triplepillooooow"));
        /**
         * 输出：11
         */
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        /**
         * 输出：1
         */
        System.out.println(maxPower("tourist"));
        System.out.println(maxPower("c"));
        System.out.println(maxPower("cc"));
    }

    public static int maxPower(String s) {
        int res = 0;
        char curChar = s.charAt(0);
        int curLen = 0;
        for (char c : s.toCharArray()) {
            if (curChar == c) {
                curLen++;
            } else {
                curChar = c;
                curLen = 1;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }

}
