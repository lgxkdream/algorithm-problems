package io.github.lgxkdream.test.unit14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 696. 计数二进制子串
 * @description https://leetcode-cn.com/problems/count-binary-substrings/
 * @since 2020-08-10 09:41
 */
public class CountBinarySubstrings {

    public static void main(String[] args) {
        /**
         * 输出: 6
         * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
         */
        System.out.println(countBinarySubstrings("00110011"));
        /**
         * 输出: 4
         * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
         */
        System.out.println(countBinarySubstrings("10101"));
    }

    public static int countBinarySubstrings(String s) {
        List<Integer> countList = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                countList.add(count);
                count = 1;
            }
        }
        countList.add(count);
        int result = 0;
        for (int i = 1; i < countList.size(); i++) {
            result += Math.min(countList.get(i), countList.get(i - 1));
        }
        return result;
    }

    public static int countBinarySubstrings1(String s) {
        int pre = 0, cur = 1, result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                result++;
            }
        }
        return result;
    }

}
