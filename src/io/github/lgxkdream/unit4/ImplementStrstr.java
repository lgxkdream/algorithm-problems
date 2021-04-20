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

    public static int strStr(String haystack, String needle) {
        if (needle == "") {
            return 0;
        }
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 < len2) {
            return -1;
        }
        for (int i = 0; i < len1 - len2 + 1; i++) {
            for (int j = i; j < i + len2; j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    break;
                }
                if (j == i + len2 - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

}
