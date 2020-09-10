package io.github.lgxkdream.test.unit16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 40. 组合总和 II
 * @description https://leetcode-cn.com/problems/combination-sum-ii/
 * @since 2020-09-10 20:49
 */
public class CombinationSumII {

    public static void main(String[] args) {
        /**
         * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
         * 所求解集为:
         * [
         *   [1, 7],
         *   [1, 2, 5],
         *   [2, 6],
         *   [1, 1, 6]
         * ]
         */
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        /**
         * 输入: candidates = [2,5,2,1,2], target = 5,
         * 所求解集为:
         * [
         *   [1,2,2],
         *   [5]
         * ]
         */
//        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private static void combinationSum2(List<List<Integer>> result, List<Integer> cur, int index, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            combinationSum2(result, cur, i + 1, candidates, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }

}
