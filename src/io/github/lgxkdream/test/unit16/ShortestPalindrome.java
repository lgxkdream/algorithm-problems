package io.github.lgxkdream.test.unit16;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 214. 最短回文串
 * @description https://leetcode-cn.com/problems/shortest-palindrome/
 * @since 2020-08-29 18:09
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }

    public static String shortestPalindrome(String s) {
        String ss = s + new StringBuilder(s).reverse().toString();
        for (int i=s.length(),j=i; i>0; i--,j++) {
            if (ss.substring(0, i).equals(ss.substring(j))) {
                return new StringBuilder(s.substring(i)).reverse().append(s).toString();
            }
        }
        return "";
    }

}
