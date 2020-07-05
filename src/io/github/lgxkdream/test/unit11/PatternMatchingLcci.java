package io.github.lgxkdream.test.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 16.18. 模式匹配
 * @description https://leetcode-cn.com/problems/pattern-matching-lcci/
 * @since 2020-06-22 00:16
 */
public class PatternMatchingLcci {

    // TODO
    public static void main(String[] args) {
        /**
         * 输出： true
         */
        System.out.println(patternMatching("abba", "dogcatcatdog"));
        /**
         * 输出： false
         */
        System.out.println(patternMatching("abba", "dogcatcatfish"));
        /**
         * 输出： false
         */
        System.out.println(patternMatching("aaaa", "dogcatcatdog"));
        /**
         * 输出： true
         * 解释： "a"="dogdog",b=""，反之也符合规则
         */
        System.out.println(patternMatching("abba", "dogdogdogdog"));
    }

    public static boolean patternMatching(String pattern, String value) {
        return false;
    }

}
