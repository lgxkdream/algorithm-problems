package io.github.lgxkdream.test.unit5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title TrapRainWater
 * @description https://leetcode-cn.com/problems/trapping-rain-water-ii/
 * @since 2020-04-12 11:21
 */
public class TrapRainWater {

    public static void main(String[] args) {
        int[][] heightMap = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}};
        System.out.println(trapRainWater(heightMap)); // 4
    }

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }
        int x = heightMap.length;
        int y = heightMap[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // 标记这个位置有没有被访问过
        boolean[][] v = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            queue.offer(new int[]{i, 0, heightMap[i][0]});
            queue.offer(new int[]{i, y - 1, heightMap[i][y - 1]});
            v[i][0] = true;
            v[i][y - 1] = true;
        }
        for (int j = 0; j < y; j++) {
            queue.offer(new int[]{0, j, heightMap[0][j]});
            queue.offer(new int[]{x - 1, j, heightMap[x - 1][j]});
            v[0][j] = true;
            v[x - 1][j] = true;
        }
        int[] dxy = {1, 0, -1, 0, 1};
        int result = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = poll[0] + dxy[i];
                int dy = poll[1] + dxy[i + 1];
                if (dx >= 0 && dx < x && dy >= 0 && dy < y && !v[dx][dy]) {
                    if (heightMap[dx][dy] < poll[2]) {
                        result += poll[2] - heightMap[dx][dy];
                        heightMap[dx][dy] = poll[2];
                    }
                    queue.offer(new int[]{dx, dy, heightMap[dx][dy]});
                    v[dx][dy] = true;
                }
            }
        }
        return result;
    }

}
