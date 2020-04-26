package io.github.lgxkdream.test.unit5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title NumberOfIslands
 * @description https://leetcode-cn.com/problems/number-of-islands/description/
 * @since 2020-04-20 10:07
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}; // 1
        // char[][] grid = {
        //         {'1', '1', '0', '0', '0'},
        //         {'1', '1', '0', '0', '0'},
        //         {'0', '0', '1', '0', '0'},
        //         {'0', '0', '0', '1', '1'}}; // 3
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    visitIsLand(grid, i, j);
                }
            }
        }
        return result;
    }

    /**
     * 标记发现的新岛
     *
     * @param grid
     * @param i
     * @param j
     */
    private static void visitIsLand(char[][] grid, int i, int j) {
        int[] dxy = {1, 0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int k = 0; k < 4; k++) {
                int dx = x + dxy[k];
                int dy = y + dxy[k + 1];
                if (dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length && grid[dx][dy] == '1') {
                    grid[dx][dy] = '2';
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
    }

}
