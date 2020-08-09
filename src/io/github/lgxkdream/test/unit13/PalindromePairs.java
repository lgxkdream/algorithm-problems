package io.github.lgxkdream.test.test13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 336. 回文对 todo 待完成！！！
 * @description https://leetcode-cn.com/problems/palindrome-pairs/
 * @since 2020-08-06 22:03
 */
public class PalindromePairs {

    public static void main(String[] args) {
        /**
         * 输出：[[0,1],[1,0],[3,2],[2,4]]
         * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
         */
        System.out.println(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        /**
         * 输出：[[0,1],[1,0]]
         * 解释：可拼接成的回文串为 ["battab","tabbat"]
         */
        System.out.println(palindromePairs(new String[]{"bat", "tab", "cat"}));
    }

    private static List<List<Integer>> res;
    private static String[] words;

    public static List<List<Integer>> palindromePairs(String[] words) {
        res = new LinkedList<>();
        PalindromePairs.words = words;
        for (int i = 0; i < words.length - 1; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                isPairs(i, j);
            }
        }
        return res;
    }

    private static void isPairs(int i, int j) {
        if (words[j].length() > words[i].length()) {
            isPairs(j, i);
            return;
        }
        String str1 = words[i], str2 = words[j];
        int l1 = str1.length(), l2 = str2.length();
        //l1 >= l2
        boolean isTrue1 = true;
        boolean isTrue2 = true;
        //判断str1的后l1-l2个字符是不是回文串
        for (int k = l2, p = l1 - 1; isTrue1 && k < p; ++k, --p) {
            isTrue1 = str1.charAt(k) == str1.charAt(p);
        }
        //判断str1的前l1-l2个字符是不是回文串
        for (int k = 0, p = l1 - l2 - 1; isTrue2 && k < p; ++k, --p) {
            isTrue2 = str1.charAt(k) == str1.charAt(p);
        }
        for (int k = 0; (isTrue1 || isTrue2) && k < l2; ++k) {
            //判断str1的前l2个字符是否与str2相反
            if (isTrue1) isTrue1 = str1.charAt(k) == str2.charAt(l2 - k - 1);
            //判断str1的后l2个字符是否与str2相反
            if (isTrue2) isTrue2 = str2.charAt(k) == str1.charAt(l1 - k - 1);
        }
        if (isTrue1) addRes(i, j);
        if (isTrue2) addRes(j, i);
    }

    private static void addRes(int i, int j) {
        ArrayList<Integer> r = new ArrayList<>();
        r.add(i);
        r.add(j);
        res.add(r);
    }

}
