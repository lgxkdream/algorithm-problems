package io.github.lgxkdream.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 318. 最大单词长度乘积
 * @description https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * @since 11/17/21 9:12 PM
 */
public class MaximumProductOfWordLengths {

    public static void main(String[] args) {
        /**
         * 输出: 16
         * 解释: 这两个单词为 "abcw", "xtfn"。
         */
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        /**
         * 输出: 4
         * 解释: 这两个单词为 "ab", "cd"。
         */
        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        /**
         * 输出: 0
         * 解释: 不存在这样的两个单词。
         */
        System.out.println(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }

    public static int maxProduct(String[] words) {
        int res = 0;
        int len = words.length;
        int[] masks = new int[len];
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char aChar : chars) {
                masks[i] |= 1 << (aChar - 'a');
            }
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

}
