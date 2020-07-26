package io.github.lgxkdream.test.test13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 17.13. 恢复空格
 * @description https://leetcode-cn.com/problems/re-space-lcci/
 * @since 2020-07-09 22:41
 */
public class ReSpaceLcci {

    public static void main(String[] args) {
        /**
         * 输出： 7
         * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
         */
        System.out.println(respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"));
    }

    /**
     * 动态规划思想 TODO
     * <p>
     * 第 i + 1 个字符未匹配，则 dp[i + 1] = dp[i] + 1，即不匹配数加 1;
     * 遍历前 i 个字符，若以其中某一个下标 idx 为开头、以第 i + 1 个字符为结尾的字符串正好在词典里，则 dp[i] = min(dp[i], dp[idx]) 更新 dp[i]。
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public static int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[n];
    }

}
