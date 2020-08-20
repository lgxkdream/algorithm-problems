package io.github.lgxkdream.test.unit15;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 647. 回文子串
 * @description https://leetcode-cn.com/problems/palindromic-substrings/
 * @since 2020-08-19 09:48
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        /**
         * 输出：3
         * 解释：三个回文子串: "a", "b", "c"
         */
        System.out.println(countSubstrings1("abc"));
        /**
         * 输出：6
         * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
         */
        System.out.println(countSubstrings1("aaa"));
        /**
         * 输出：4
         */
        System.out.println(countSubstrings1("aba"));
    }

    /**
     * 0  0  0
     * 1  0  1
     * 2  1  1
     * 3  1  2
     * 4  2  2
     * 5  2  3
     * 6  3  3
     */
    public static int countSubstrings1(String s) {
        int result = 0, len = s.length();
        for (int i = 0; i < len * 2 - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < len && s.charAt(l--) == s.charAt(r++)) {
                result++;
            }
        }
        return result;
    }

    public static int countSubstrings(String s) {
        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isPalindromic(s.substring(i, j))) {
                    result++;
                } else {
                    continue;
                }
            }
        }
        return result;
    }

    private static boolean isPalindromic(String s) {
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
