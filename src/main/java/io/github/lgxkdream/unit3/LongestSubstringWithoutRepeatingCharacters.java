package io.github.lgxkdream.unit3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 无重复字符的最长子串
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @since 2020-05-02 12:32
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        // System.out.println(lengthOfLongestSubstring(s)); // 3
        // s = "bbbbb";
        // System.out.println(lengthOfLongestSubstring(s)); // 1
        // s = "pwwkew";
        // System.out.println(lengthOfLongestSubstring(s)); // 3
        s = "abba";
        System.out.println(lengthOfLongestSubstring(s)); // 2
    }

    public static int lengthOfLongestSubstring(String s) {
        // 用于存储已出现的字符和该字符最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        // 当前长度最大值和左指针位置
        int result = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 发现字符存在，更新左指针位置
                // 注意 不能写成 left = map.get(s.charAt(i)) + 1, 因为 abba 这种情况当遍历到索引i为3时，
                // 由于b重复左指针left已经到了2，不能更新为a的第一次位置+1(即0+1=1)
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 更新已出现的字符和该字符最后出现的位置
            map.put(s.charAt(i), i);
            // 求当前最大长度
            result = Math.max(result, i - left + 1);
        }
        return result;
    }

}
