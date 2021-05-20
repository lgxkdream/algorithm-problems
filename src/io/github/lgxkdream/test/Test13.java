package io.github.lgxkdream.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2021-05-20 21:46
 */
public class Test13 {

    public static void main(String[] args) {
        /**
         * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
         * 输出: ["the", "is", "sunny", "day"]
         * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
         *     出现次数依次为 4, 3, 2 和 1 次。
         */
        // System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        // System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"glarko", "zlfiwwb", "nsfspyox", "pwqvwmlgri", "qggx",
                "qrkgmliewc", "zskaqzwo", "zskaqzwo", "ijy", "htpvnmozay", "jqrlad", "ccjel", "qrkgmliewc", "qkjzgws",
                "fqizrrnmif", "jqrlad", "nbuorw", "qrkgmliewc", "htpvnmozay", "nftk", "glarko", "hdemkfr", "axyak",
                "hdemkfr", "nsfspyox", "nsfspyox", "qrkgmliewc", "nftk", "nftk", "ccjel", "qrkgmliewc", "ocgjsu", "ijy",
                "glarko", "nbuorw", "nsfspyox", "qkjzgws", "qkjzgws", "fqizrrnmif", "pwqvwmlgri", "nftk", "qrkgmliewc",
                "jqrlad", "nftk", "zskaqzwo", "glarko", "nsfspyox", "zlfiwwb", "hwlvqgkdbo", "htpvnmozay", "nsfspyox",
                "zskaqzwo", "htpvnmozay", "zskaqzwo", "nbuorw", "qkjzgws", "zlfiwwb", "pwqvwmlgri", "zskaqzwo", "qengse",
                "glarko", "qkjzgws", "pwqvwmlgri", "fqizrrnmif", "nbuorw", "nftk", "ijy", "hdemkfr", "nftk", "qkjzgws",
                "jqrlad", "nftk", "ccjel", "qggx", "ijy", "qengse", "nftk", "htpvnmozay", "qengse", "eonrg", "qengse",
                "fqizrrnmif", "hwlvqgkdbo", "qengse", "qengse", "qggx", "qkjzgws", "qggx", "pwqvwmlgri", "htpvnmozay",
                "qrkgmliewc", "qengse", "fqizrrnmif", "qkjzgws", "qengse", "nftk", "htpvnmozay", "qggx", "zlfiwwb", "bwp",
                "ocgjsu", "qrkgmliewc", "ccjel", "hdemkfr", "nsfspyox", "hdemkfr", "qggx", "zlfiwwb", "nsfspyox", "ijy",
                "qkjzgws", "fqizrrnmif", "qkjzgws", "qrkgmliewc", "glarko", "hdemkfr", "pwqvwmlgri"}, 14));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = Arrays.stream(words).collect(Collectors.toMap(Function.identity(), n -> 1, Integer::sum));
        System.out.println(countMap);
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            if (countMap.get(b) == countMap.get(a)) {
                return b.compareTo(a);
            }
            return countMap.get(a) - countMap.get(b);
        });
        countMap.forEach((word, count) -> {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        });
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        // 错误写法1
        // queue.forEach(word -> res.add(word));
        // 错误写法2
        // for (String word : queue) {
        //     res.add(word);
        // }
        Collections.reverse(res);
        return res;
    }

}
