package io.github.lgxkdream.test.unit4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MovingCount
 * @description https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @since 2020-04-08 09:55
 */
public class MovingCount {

    public static void main(String[] args) {
        // int m = 2, n = 3, k = 1; // 3
        // int m = 3, n = 1, k = 0; // 1
        int m = 16, n = 8, k = 4;
        System.out.println(movingCount(m, n, k));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] v = new int[m][n];
        return movingCount(0, 0, 0, 0, m, n, k, v);
    }

    /**
     * @param x  x坐标
     * @param y  y坐标
     * @param xs x坐标位数之和
     * @param ys y坐标位数之和
     * @param m  x坐标最大值
     * @param n  y坐标最大值
     * @param k  x和y坐标位数之和的最大值
     * @param v  访问标记
     * @return
     */
    private static int movingCount(int x, int y, int xs, int ys, int m, int n, int k, int[][] v) {
        if (x >= m || y >= n || v[x][y] == 1 || (xs + ys > k)) {
            return 0;
        }
        v[x][y] = 1;
        return movingCount(x, y + 1, xs, (y + 1) % 10 == 0 ? ys - 8 : ys + 1, m, n, k, v)
                + movingCount(x + 1, y, (x + 1) % 10 == 0 ? xs - 8 : xs + 1, ys, m, n, k, v) + 1;
    }

    public static int movingCount1(int m, int n, int k) {
        int result = 0;
        int[][] v = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], xs = poll[2], ys = poll[3];
            if (x >= m || y >= n || v[x][y] == 1 || (xs + ys > k)) {
                continue;
            }
            v[x][y] = 1;
            result++;
            queue.offer(new int[]{x, y + 1, xs, (y + 1) % 10 == 0 ? ys - 8 : ys + 1});
            queue.offer(new int[]{x + 1, y, (x + 1) % 10 == 0 ? xs - 8 : xs + 1, ys});
        }
        return result;
    }

    private static int getSum(int num) {
        int a = 0;
        while (num > 0) {
            a += num % 10;
            num = num / 10;
        }
        return a;
    }

}
