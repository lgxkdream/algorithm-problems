package io.github.lgxkdream.test.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 10. 正则表达式匹配
 * @description https://leetcode-cn.com/problems/regular-expression-matching/
 * @since 2020-06-20 09:40
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        /**
         * 输出: false
         * 解释: "a" 无法匹配 "aa" 整个字符串。
         */
        // System.out.println(isMatch("aa", "a"));
        /**
         * 输出: true
         * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
         */
        System.out.println(isMatch("aa", "a*"));
        /**
         * 输出: true
         * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
         */
        // System.out.println(isMatch("ab", ".*"));
        /**
         * 输出: true
         * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
         */
        // System.out.println(isMatch("aab", "c*a*b"));
        /**
         * 输出: false
         */
        // System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * 错误解法
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch1(String s, String p) {
        if (s.isEmpty()) {
            // 对于s="",p="a*" 这种是true的，因为*可以匹配0个前面的元素
            return p.isEmpty();
        }
        boolean firstMatch = !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch1(s, p.substring(2)) || (firstMatch && isMatch1(s.substring(1), p));
        } else {
            return firstMatch && isMatch1(s.substring(1), p.substring(1));
        }
    }

}
