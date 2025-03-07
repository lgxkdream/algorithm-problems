package io.github.lgxkdream.test.unit17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 47. 全排列 II
 * @description https://leetcode-cn.com/problems/permutations-ii/
 * @since 2020-09-18 10:29
 */
public class PermutationsII {

    public static void main(String[] args) {
        /**
         * 输出:
         * [
         *   [1,1,2],
         *   [1,2,1],
         *   [2,1,1]
         * ]
         */
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

}
