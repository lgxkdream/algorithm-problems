package io.github.lgxkdream.unit4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title: 378. 有序矩阵中第K小的元素
 * @description: https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @Copyright: Copyright (c) 2019
 * @company: lgxkdream.github.io
 * @since 2020年7月2日 下午07:43:18
 */
public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        /**
         * 返回 13。
         */
        System.out.println(kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}}, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue(Comparator.comparingInt(a -> ((int[]) a)[0]));
        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new int[]{matrix[i][0], i, 0});
        }
        int len = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (--k == 0) {
                return poll[0];
            } else if (poll[2] < len - 1) {
                queue.offer(new int[]{matrix[poll[1]][poll[2] + 1], poll[1], poll[2] + 1});
            }
        }
        return -1;
    }
}