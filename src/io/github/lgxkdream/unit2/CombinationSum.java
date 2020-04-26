package io.github.lgxkdream.unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @title: CombinationSum(组合总和) https://leetcode-cn.com/problems/combination-sum/
 * @description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *               candidates 中的数字可以无限制重复被选取。
 *               说明：
 *               所有数字（包括 target）都是正整数。
 *               解集不能包含重复的组合。 
 *               示例:
 *               输入: candidates = [2,3,6,7], target = 7,
 *               所求解集为:
 *               [
 *                 [7],
 *                 [2,2,3]
 *               ]
 * @Copyright: Copyright (c) 2020
 * @company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2020年1月16日 下午16:16:45
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getResult(candidates, 0, target, 0, result, new ArrayList<>());
        System.out.println(result);
    }

    private static void getResult(int[] candidates, int start, int target, int curTarget, List<List<Integer>> result, List<Integer> oneResult) {
        if (curTarget > target) {
            // 递归出口，当前总和大于目标总和
            return;
        }
        if (target == curTarget) {
            // 递归出口，当前总和等于目标总和，记录当前结果
            result.add(oneResult);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 拷贝一份，不影响下次递归
            List<Integer> temp = new ArrayList<>(oneResult);
            temp.add(candidates[i]);
            // 递归获取结果的下一位数字
            getResult(candidates, i, target, curTarget + candidates[i], result, temp);
        }
    }

}
