package io.github.lgxkdream.test.unit3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 1162. 地图分析
 * @description https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * @since 2020-03-27 10:03
 */
public class AsFarFromLandAsPossible {

    public static void main(String[] args) {
        // int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(maxDistance1(grid));
    }

    /**
     * 广度优先遍历思想
     *
     * @param grid
     * @return
     */
    public static int maxDistance1(int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }
        if (queue.isEmpty() || queue.size() == grid.length * grid.length) {
            return -1;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Point p = null;
        while (!queue.isEmpty()) {
            p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == 0) {
                    grid[x][y] = 1;
                    queue.offer(new Point(x, y, p.step + 1));
                }
            }
        }
        return p.step;
    }

    static class Point {
        int x;
        int y;
        int step;

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

}
