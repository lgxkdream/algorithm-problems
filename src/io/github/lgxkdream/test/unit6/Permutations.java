package io.github.lgxkdream.test.unit6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 全排列
 * @description https://leetcode-cn.com/problems/permutations/
 * @since 2020-04-25 09:40
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        System.out.println(permute(nums));
    }

    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        permute(nums, stack, 0, result);
        return result;
    }

    private static void permute(int[] nums, Stack<Integer> stack, int depth, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!stack.contains(nums[i])) {
                stack.push(nums[i]);
                permute(nums, stack, depth + 1, result);
                stack.pop();
            }
        }
    }

}
