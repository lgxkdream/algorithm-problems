package io.github.lgxkdream.unit8;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 10.02. 变位词组
 * @description
 * @since 7/18/21 11:46 PM
 */
public class Submissions {

    public static void main(String[] args) {
        /**
         * 输出:
         * [
         *   ["ate","eat","tea"],
         *   ["nat","tan"],
         *   ["bat"]
         * ]
         */
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

}
