package io.github.lgxkdream.test.unit8;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 最小覆盖子串
 * @description https://leetcode-cn.com/problems/minimum-window-substring/
 * @since 2020-05-23 09:05
 */
public class MinimumWindowSubstring {

    // TODO 隔一段时间重新练习
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
    }

    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }
        int matchCount = 0;
        char[] sCount = new char[128];
        char[] tCount = new char[128];
        for (char tc : t.toCharArray()) {
            tCount[tc]++;
        }
        int begin = 0, minLen = sLen + 1, left = 0, right = 0;
        char[] sChars = s.toCharArray();
        while (right < sLen) {
            while (matchCount < tLen && right < sLen) {
                if (tCount[sChars[right]] == 0) {
                    right++;
                    continue;
                }
                if (sCount[sChars[right]] < tCount[sChars[right]]) {
                    matchCount++;
                }
                sCount[sChars[right++]]++;
            }
            while (matchCount == tLen) {
                if (right - left < minLen) {
                    begin = left;
                    minLen = right - left;
                }
                if (tCount[sChars[left]] == 0) {
                    left++;
                    continue;
                }
                if (sCount[sChars[left]] == tCount[sChars[left]]) {
                    matchCount--;
                }
                sCount[sChars[left++]]--;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

}
