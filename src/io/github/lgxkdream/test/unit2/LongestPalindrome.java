package io.github.lgxkdream.test.unit2;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title LongestPalindrome
 * @description
 * @since 2020-03-19 15:05
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "bananas";
        System.out.println(longestPalindrome(str));
    }

    public static int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            System.out.println(c);
            System.out.println(c-65);
            count[c - 65]++;
        }
        int other = 0;
        int result = 0;
        for (int i : count) {
            if (i % 2 != 0) {
                other = 1;
            }
            result = result + (i / 2);
        }
        return result * 2 + other;
    }

}
