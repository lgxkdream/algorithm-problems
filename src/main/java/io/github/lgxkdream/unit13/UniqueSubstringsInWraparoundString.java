package io.github.lgxkdream.unit13;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 467. 环绕字符串中唯一的子字符串
 * @description https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * @since 2022-05-25 15:20
 */
public class UniqueSubstringsInWraparoundString {

    public static void main(String[] args) {
        /**
         * 输出: 1
         * 解释: 字符串 s 中只有一个"a"子字符。
         */
        System.out.println(findSubstringInWraproundString("a"));
        /**
         * 输出: 2
         * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
         */
        System.out.println(findSubstringInWraproundString("cac"));
        /**
         * 输出: 6
         * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
         */
        System.out.println(findSubstringInWraproundString("zab"));
    }

    public static int findSubstringInWraproundString(String p) {
        int[] max = new int[26];
        int len = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - 'a') == (p.charAt(i - 1) - 'a' + 1) % 26) {
                len++;
            } else {
                len = 1;
            }
            max[p.charAt(i) - 'a'] = Math.max(max[p.charAt(i) - 'a'], len);
        }
        return Arrays.stream(max).sum();
    }

}
