package io.github.lgxkdream.test.unit14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 733. 图像渲染
 * @description https://leetcode-cn.com/problems/flood-fill/
 * @since 2020-08-16 21:57
 */
public class FloodFill {

    public static void main(String[] args) {
        /**
         * 输出: [[2,2,2],[2,2,0],[2,0,1]]
         * 解析:
         * 在图像的正中间，(坐标(sr,sc)=(1,1)),
         * 在路径上所有符合条件的像素点的颜色都被更改成2。
         * 注意，右下角的像素没有更改为2，
         * 因为它不是在上下左右四个方向上与初始点相连的像素点。
         */
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }

    /**
     * 广度优先遍历思想
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null && image.length == 0) {
            return image;
        }
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc], x = image.length, y = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int[] dxy = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            image[poll[0]][poll[1]] = newColor;
            for (int i = 0; i < 4; i++) {
                int dsr = poll[0] + dxy[i];
                int dsc = poll[1] + dxy[i + 1];
                if (dsr >= 0 && dsr < x && dsc >= 0 && dsc < y && image[dsr][dsc] == oldColor) {
                    queue.offer(new int[]{dsr, dsc});
                }
            }
        }
        return image;
    }

}
