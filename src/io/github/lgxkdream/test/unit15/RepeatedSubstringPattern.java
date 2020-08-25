package io.github.lgxkdream.test.unit15;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 459. 重复的子字符串
 * @description https://leetcode-cn.com/problems/repeated-substring-pattern/
 * @since 2020-08-24 09:33
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        /**
         * 输出: True
         *
         * 解释: 可由子字符串 "ab" 重复两次构成。
         */
        System.out.println(repeatedSubstringPattern("abab"));
        /**
         * 输出: False
         */
        System.out.println(repeatedSubstringPattern("aba"));
        /**
         * 输出: True
         *
         * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
         */
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

}
