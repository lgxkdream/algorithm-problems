package io.github.lgxkdream.unit8;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1743. 从相邻元素对还原数组
 * @description
 * @since 7/25/21 10:22 PM
 */
public class RestoreTheArrayFromAdjacentPairs {

    public static void main(String[] args) {
        /**
         * 输出：[1,2,3,4]
         * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
         * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
         */
        System.out.println(Arrays.toString(restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
        /**
         * 输出：[-2,4,1,-3]
         * 解释：数组中可能存在负数。
         * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
         */
        System.out.println(Arrays.toString(restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}})));
        /**
         * 输出：[100000,-100000]
         */
        System.out.println(Arrays.toString(restoreArray(new int[][]{{100000, -100000}})));
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int[] res = new int[adjacentPairs.length + 1];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[0] = entry.getKey();
                res[1] = entry.getValue().get(0);
                break;
            }
        }
        for (int i = 2; i < adjacentPairs.length + 1; i++) {
            List<Integer> list = map.get(res[i - 1]);
            res[i] = list.get(0) == res[i - 2] ? list.get(1) : list.get(0);
        }
        return res;
    }

}
