package io.github.lgxkdream.test.unit16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 39. 组合总和
 * @description https://leetcode-cn.com/problems/combination-sum/
 * @since 2020-09-09 21:15
 */
public class CombinationSum {

    public static void main(String[] args) {
        /**
         * 所求解集为：
         * [
         *   [7],
         *   [2,2,3]
         * ]
         */
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        /**
         * 所求解集为：
         * [
         *   [2,2,2,2],
         *   [2,3,3],
         *   [3,5]
         * ]
         */
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }

    /**
     * 回溯思想
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, new ArrayList<>(), 0, 0, candidates, target);
        return result;
    }

    private static void combinationSum(List<List<Integer>> result, List<Integer> cur, int index, int sum, int[] candidates, int target) {
        if (sum == target) {
            List<Integer> list = Arrays.asList(new Integer[cur.size()]);
            Collections.copy(list, cur);
            result.add(list);
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            combinationSum(result, cur, i, sum + candidates[i], candidates, target);
            cur.remove(Integer.valueOf(candidates[i]));
        }
    }

}
