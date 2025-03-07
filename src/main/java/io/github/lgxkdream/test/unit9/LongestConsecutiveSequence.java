package io.github.lgxkdream.test.unit9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @description 最长连续序列
 * @since 2020-06-06 12:46
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        /**
         * 输出: 4
         * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
         */
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curLen = 0, curNum = num;
                while (set.contains(curNum)) {
                    curLen++;
                    curNum++;
                }
                result = Math.max(result, curLen);
            }
        }
        return result;
    }

}
