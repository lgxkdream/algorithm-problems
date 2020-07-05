package io.github.lgxkdream.test.unit12;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 139. 单词拆分
 * @description https://leetcode-cn.com/problems/word-break/
 * @since 2020-06-25 10:21
 */
public class WordBreak {

    public static void main(String[] args) {
        /**
         * 输出: true
         * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
         */
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        /**
         * 输出: true
         * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
         *       注意你可以重复使用字典中的单词。
         */
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        /**
         * 输出: false
         */
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        /**
         * 输出: true
         */
        System.out.println(wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
    }

    // public static boolean wordBreak(String s, List<String> wordDict) {
    // }

    /**
     * 动态规划思想
     * dp[i] = dp[j] && contains(str[j, i))
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];

        // 错误解法
        // Collections.sort(wordDict, (a, b) -> b.length() - a.length());
        // for (String wd : wordDict) {
        //     while (s.indexOf(wd) != -1) {
        //         s = s.substring(0, s.indexOf(wd)) + s.substring(s.indexOf(wd) + wd.length());
        //     }
        // }
        // return s.isEmpty();
    }

}
