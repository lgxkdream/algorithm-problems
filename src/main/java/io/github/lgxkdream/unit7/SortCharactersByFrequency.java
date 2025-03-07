package io.github.lgxkdream.unit7;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 451. 根据字符出现频率排序
 * @description https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * @since 7/3/21 9:11 PM
 */
public class SortCharactersByFrequency {


    public static void main(String[] args) {
        /**
         * 输出:
         * "eert"
         *
         * 解释:
         * 'e'出现两次，'r'和't'都只出现一次。
         * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
         */
        System.out.println(frequencySort("tree"));
        /**
         * 输出:
         * "cccaaa"
         *
         * 解释:
         * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
         * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
         */
        System.out.println(frequencySort("cccaaa"));
        /**
         * 输出:
         * "bbAa"
         *
         * 解释:
         * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
         * 注意'A'和'a'被认为是两种不同的字符。
         */
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            Integer num = map.get(c);
            for (int i = 0; i < num; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
