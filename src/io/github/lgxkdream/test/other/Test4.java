package io.github.lgxkdream.test.other;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiGang
 * @version 1.0.0
 * @title Test5
 * @description
 * @since 2020-01-16 15:20
 */
public class Test4 {

    /**
     * [
     * [7],
     * [2,2,3]
     * ]
     */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getResult(candidates, 0, target, 0, result, Lists.newArrayList());
        System.out.println(result);
    }

    private static void getResult(int[] candidates, int start, int target, int curTarget, List<List<Integer>> result, List<Integer> oneResult) {
        if (curTarget > target) {
            return;
        }
        if (target == curTarget) {
            result.add(oneResult);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            List<Integer> temp = Lists.newArrayList(oneResult);
            temp.add(candidates[i]);
            getResult(candidates, i, target, curTarget + candidates[i], result, temp);
        }
    }
}
