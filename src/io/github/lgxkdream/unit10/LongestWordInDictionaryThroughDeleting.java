package io.github.lgxkdream.unit10;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 524. 通过删除字母匹配到字典里最长单词
 * @description https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * @since 2021-09-14 21:08
 */
public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {
        /**
         * 输出："apple"
         */
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        /**
         * 输出："a"
         */
        System.out.println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
        /**
         * 输出："abc"
         */
        System.out.println(findLongestWord("abce", Arrays.asList("abe", "abc")));
    }

    /**
     * 双指针
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String dic : dictionary) {
            int i = 0, j = 0;
            while (i < s.length() && j < dic.length()) {
                if (s.charAt(i) == dic.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == dic.length() && (dic.length() > res.length() || (dic.length() == res.length() && dic.compareTo(res) < 0))) {
                res = dic;
            }
        }
        return res;
    }

}
