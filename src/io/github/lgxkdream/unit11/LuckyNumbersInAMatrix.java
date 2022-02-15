package io.github.lgxkdream.unit11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1380. 矩阵中的幸运数
 * @description https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * @since 2022-02-15 22:31
 */
public class LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        /**
         * 输出：[15]
         * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
         */
        System.out.println(luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        /**
         * 输出：[12]
         * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
         */
        System.out.println(luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}));
        /**
         * 输出：[7]
         */
        System.out.println(luckyNumbers(new int[][]{{7, 8}, {1, 2}}));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

}
