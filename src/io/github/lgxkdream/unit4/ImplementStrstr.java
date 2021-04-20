package io.github.lgxkdream.unit4;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 28. 实现 strStr()
 * @description https://leetcode-cn.com/problems/implement-strstr/
 * @since 2021-04-20 22:09
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        /**
         * 输出：2
         */
        System.out.println(strStr("hello", "ll"));
        /**
         * 输出：-1
         */
        System.out.println(strStr("aaaaa", "bba"));
        /**
         * 输出：0
         */
        System.out.println(strStr("", ""));
    }

    /**
     * 暴力匹配
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int len1 = haystack.length(), len2 = needle.length();
        for (int i = 0; i < len1 - len2 + 1; i++) {
            for (int j = 0; j < len2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == len2 - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

}
