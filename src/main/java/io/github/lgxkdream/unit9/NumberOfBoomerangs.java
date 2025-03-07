package io.github.lgxkdream.unit9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 447. 回旋镖的数量
 * @description https://leetcode-cn.com/problems/number-of-boomerangs/
 * @since 9/13/21 11:50 PM
 */
public class NumberOfBoomerangs {

    public static void main(String[] args) {
        /**
         * 输入：points = [[0,0],[1,0],[2,0]]
         * 输出：2
         * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
         */
        System.out.println(numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        /**
         * 输出：2
         */
        System.out.println(numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        /**
         * 输出：0
         */
        System.out.println(numberOfBoomerangs(new int[][]{{1, 1}}));
    }

    /**
     * 枚举 + 哈希表
     */
    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] point : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] ints : points) {
                int distance = (point[0] - ints[0]) * (point[0] - ints[0]) + (point[1] - ints[1]) * (point[1] - ints[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return res;
    }

}
