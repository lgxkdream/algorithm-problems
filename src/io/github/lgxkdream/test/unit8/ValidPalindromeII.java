package io.github.lgxkdream.test.unit8;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 验证回文字符串 Ⅱ
 * @description https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @since 2020-05-19 10:06
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        // 输出: True
        System.out.println(validPalindrome("aba"));
        // 输出: True
        // 解释: 可以删除c字符。
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindrome(s, i, j - 1) || validPalindrome(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean validPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
