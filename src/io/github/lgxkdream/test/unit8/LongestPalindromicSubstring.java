package io.github.lgxkdream.test.unit8;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 最长回文子串
 * @description https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @since 2020-05-21 09:52
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        /**
         * 输出: "bab"
         * 注意: "aba" 也是一个有效答案。
         */
        System.out.println(longestPalindrome("babad"));

        /**
         * 输出: "bb"
         */
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 中心扩展算法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int begin = 0, maxLen = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int curMaxLen = Math.max(longestPalindrome(s, i, i), longestPalindrome(s, i, i + 1));
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static int longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     * dp[i][j] = (s[i]==s[j]) && ((j-i<3) || dp[i+1][j-1])
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int begin = 0, maxLen = 1;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else if ((j - i < 3) || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
