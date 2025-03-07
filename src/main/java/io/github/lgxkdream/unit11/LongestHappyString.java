package io.github.lgxkdream.unit11;

import java.util.PriorityQueue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1405. 最长快乐字符串
 * @description https://leetcode-cn.com/problems/longest-happy-string/
 * @since 2022-02-07 22:09
 */
public class LongestHappyString {

    public static void main(String[] args) {
        /**
         * 输出："ccaccbcc"
         * 解释："ccbccacc" 也是一种正确答案。
         */
        System.out.println(longestDiverseString(1, 1, 7));
        /**
         * 输出："aabbc"
         */
        System.out.println(longestDiverseString(2, 2, 1));
        /**
         * 输出："aabaa"
         * 解释：这是该测试用例的唯一正确答案。
         */
        System.out.println(longestDiverseString(7, 1, 0));
    }

    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<CharCount> queue = new PriorityQueue<>((c1, c2) -> c2.count - c1.count);
        if (a > 0) queue.offer(new CharCount(a, 'a'));
        if (b > 0) queue.offer(new CharCount(b, 'b'));
        if (c > 0) queue.offer(new CharCount(c, 'c'));
        while (queue.isEmpty()) {
            
        }
        return res.toString();
    }

    static class CharCount {
        int count;
        char ch;

        public CharCount(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

}
