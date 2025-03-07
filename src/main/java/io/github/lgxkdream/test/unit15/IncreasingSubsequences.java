package io.github.lgxkdream.test.unit15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 491. 递增子序列
 * @description https://leetcode-cn.com/problems/increasing-subsequences/
 * @since 2020-08-25 09:38
 */
public class IncreasingSubsequences {

    public static void main(String[] args) {
        /**
         * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
         */
        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        return new ArrayList<>();
    }

}
