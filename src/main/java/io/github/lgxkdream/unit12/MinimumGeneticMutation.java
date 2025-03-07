package io.github.lgxkdream.unit12;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 433. 最小基因变化
 * @description https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * @since 2022-05-07 23:10
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        /**
         * 输出：1
         */
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        /**
         * 输出：2
         */
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        /**
         * 输出：3
         */
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        /**
         * 输出：4
         */
        System.out.println(minMutation("AAAACCCC", "CCCCCCCC", new String[]{"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"}));
    }

    public static int minMutation(String start, String end, String[] bank) {
        int res = 0;
        if (start.equals(end)) {
            return res;
        }
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] keys = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        res = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                String poll = queue.poll();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (poll.charAt(i) != keys[j]) {
                            StringBuilder sb = new StringBuilder(poll);
                            sb.setCharAt(i, keys[j]);
                            String newStr = sb.toString();
                            if (!visited.contains(newStr) && bankSet.contains(newStr)) {
                                if (newStr.equals(end)) {
                                    return res;
                                }
                                visited.add(newStr);
                                queue.offer(newStr);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

}
