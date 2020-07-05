package io.github.lgxkdream.test.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 14. 最长公共前缀
 * @description https://leetcode-cn.com/problems/longest-common-prefix/
 * @since 2020-06-15 10:03
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        /**
         * 输出: "fl"
         */
        System.out.println("1、" + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        /**
         * 输出: ""
         */
        System.out.println("2、" + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    /**
     * 纵向扫描
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || chars[i] != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
