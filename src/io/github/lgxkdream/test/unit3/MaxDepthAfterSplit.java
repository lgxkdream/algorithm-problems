package io.github.lgxkdream.test.unit3;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MaxDepthAfterSplit
 * @description https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * @since 2020-04-01 10:31
 */
public class MaxDepthAfterSplit {

    public static void main(String[] args) {
        String seq = "()((()))()";
        // 深度 1 1 1 2 3 3 2 1 1 1
        // 把奇偶深度拆分出来才能最大限度的减少拆分后的深度
        Arrays.stream(maxDepthAfterSplit(seq)).forEach(System.out::println);
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            result[i] = seq.charAt(i) == '(' ? i & 1 : (i + 1) & 1;
        }
        return result;
    }

}
