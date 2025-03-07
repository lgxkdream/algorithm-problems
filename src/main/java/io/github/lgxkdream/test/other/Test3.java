package io.github.lgxkdream.test.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiGang
 * @version 1.0.0
 * @title Test3
 * @description
 * @since 2020-01-16 15:10
 */
public class Test3 {

    public static void main(String[] args) {
        int[] candidates = {1, 2, 4, 8};
        List<String> result = new ArrayList<>();
        getResult(candidates, 0, 2, 0, result, "");
        System.out.println(result);
    }

    public static void getResult(int[] candidates, int start, int length, int curLen, List<String> result, String oneResult) {
        if (curLen == length) {
            result.add(oneResult);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            getResult(candidates, i + 1, length, curLen + 1, result, oneResult + candidates[i]);
        }
    }
}
