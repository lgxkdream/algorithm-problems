package io.github.lgxkdream.test.unit4;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Rotate
 * @description https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * @since 2020-04-07 10:00
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[i][length - j - 1];
                matrix[i][length - j - 1] = matrix[i][j] ^ matrix[i][length - j - 1];
                matrix[i][j] = matrix[i][j] ^ matrix[i][length - j - 1];
            }
        }
    }

}
