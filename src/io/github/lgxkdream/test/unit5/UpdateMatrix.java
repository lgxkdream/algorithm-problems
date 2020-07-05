package io.github.lgxkdream.test.unit5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 542. 01 矩阵
 * @description https://leetcode-cn.com/problems/01-matrix/
 * @since 2020-04-15 10:07
 */
public class UpdateMatrix {

    public static void main(String[] args) {
        // int[][] matrix = {
        //         {0, 0, 0},
        //         {0, 1, 0},
        //         {0, 0, 0}
        // };
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
    }

    /**
     * 广度优先遍历
     *
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] v = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    v[i][j] = 1;
                }
            }
        }
        int[] dxy = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int dx = x + dxy[i];
                int dy = y + dxy[i + 1];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && v[dx][dy] == 0) {
                    matrix[dx][dy] = matrix[x][y] + 1;
                    v[dx][dy] = 1;
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
        return matrix;
    }

}
