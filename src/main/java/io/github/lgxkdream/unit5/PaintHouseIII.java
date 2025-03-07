package io.github.lgxkdream.unit5;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1473. 粉刷房子 III
 * @description https://leetcode-cn.com/problems/paint-house-iii/
 * @since 5/4/21 8:04 PM
 */
public class PaintHouseIII {

    public static void main(String[] args) {
        /**
         * 输出：9
         * 解释：房子涂色方案为 [1,2,2,1,1]
         * 此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
         * 涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
         */
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{
                {1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}
        }, 5, 2, 3));
        /**
         * 输出：11
         * 解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
         * 此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
         * 给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
         */
        System.out.println(minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{
                {1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}
        }, 5, 2, 3));
        /**
         * 输出：5
         */
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{
                {1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}
        }, 5, 2, 5));
        /**
         * 输出：-1
         * 解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
         */
        System.out.println(minCost(new int[]{3, 1, 2, 3}, new int[][]{
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}
        }, 4, 3, 3));
    }

    public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        return 0;
    }

}
