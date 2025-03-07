package io.github.lgxkdream.test.unit9;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 面试题29. 顺时针打印矩阵
 * @description https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @since 2020-06-05 09:51
 */
public class ShunShiZhenDaYinJuZhenLcof {

    public static void main(String[] args) {
        /**
         * 输出：[1, 2, 3, 6, 9, 8, 7, 4, 5]
         */
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        /**
         * 输出：[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
         */
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, x = 0;
        int[] result = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = left; i <= right; i++) {
                result[x++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result[x++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result[x++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result[x++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }

}
