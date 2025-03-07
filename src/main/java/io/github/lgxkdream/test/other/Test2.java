package io.github.lgxkdream.test.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiGang
 * @version 1.0.0
 * @title Test2
 * @description
 * @since 2020-01-16 15:12
 */
public class Test2 {

    public static void main(String[] args) {
        int[] candidates = {1, 2, 4, 8};
        List<List<Integer>> result = new ArrayList<>();
        getResult(candidates, 0, 3, 0, result, new ArrayList<>());
        System.out.println(result);
    }

    /**
     * 1 2 4 8
     */

    public static void getResult(int[] candidates, int start, int length, int curLen, List<List<Integer>> result, List<Integer> oneResult) {
        if (curLen == length) {
            result.add(new ArrayList<>(oneResult));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            oneResult.add(candidates[i]);
            getResult(candidates, i + 1, length, curLen + 1, result, oneResult);
            oneResult.remove(oneResult.size() - 1);
        }
    }

}
