package io.github.lgxkdream.test.unit17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 78. 子集
 * @description https://leetcode-cn.com/problems/subsets/
 * @since 2020-09-20 20:44
 */
public class Subsets {

    public static void main(String[] args) {
        /**
         * 输出:
         * [
         *   [3],
         *   [1],
         *   [2],
         *   [1,2,3],
         *   [1,3],
         *   [2,3],
         *   [1,2],
         *   []
         * ]
         */
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsets(nums, result, new ArrayList<>(), i, 0);
        }
        return result;
    }

    private static void subsets(int[] nums, List<List<Integer>> result, List<Integer> subResult, int count, int index) {
        if (count == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            subResult.add(nums[i]);
            subsets(nums, result, subResult, count - 1, i + 1);
            subResult.remove(subResult.size() - 1);
        }
    }

}
