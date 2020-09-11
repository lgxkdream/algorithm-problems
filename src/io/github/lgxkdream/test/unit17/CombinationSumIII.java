package io.github.lgxkdream.test.unit17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 216. 组合总和 III
 * @description https://leetcode-cn.com/problems/combination-sum-iii/
 * @since 2020-09-11 10:04
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        /**
         * 输出: [[1,2,4]]
         */
        System.out.println(combinationSum3(3, 7));
        /**
         * 输出: [[1,2,6], [1,3,5], [2,3,4]]
         */
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    private static void combinationSum3(List<List<Integer>> result, List<Integer> cur, int start, int k, int n) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < 10; i++) {
            if (k < 0 || n - i < 0) {
                break;
            }
            cur.add(i);
            combinationSum3(result, cur, i + 1, k - 1, n - i);
            cur.remove(cur.size() - 1);
        }
    }

}
