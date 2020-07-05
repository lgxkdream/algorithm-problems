package io.github.lgxkdream.test.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 44. 通配符匹配
 * @description https://leetcode-cn.com/problems/wildcard-matching/
 * @since 2020-07-05 10:26
 */
public class WildcardMatching {

    public static void main(String[] args) {
        /**
         * 输出: false
         * 解释: "a" 无法匹配 "aa" 整个字符串。
         */
        System.out.println(isMatch("aa", "a"));
        /**
         * 输出: true
         * 解释: '*' 可以匹配任意字符串。
         */
        System.out.println(isMatch("aa", "*"));
        /**
         * 输出: false
         * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
         */
        System.out.println(isMatch("cb", "?a"));
        /**
         * 输出: true
         * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
         */
        System.out.println(isMatch("adceb", "*a*b"));
        /**
         * 输出: false
         */
        System.out.println(isMatch("acdcb", "a*c?b"));
    }

    /**
     * 动态规划思想
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 1; j <= pLen; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static boolean isMatch1(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) || (!s.isEmpty() && isMatch(s.substring(1), p));
        } else {
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') && isMatch(s.substring(1), p.substring(1));
        }
    }

}
