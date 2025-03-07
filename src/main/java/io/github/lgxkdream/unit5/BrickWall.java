package io.github.lgxkdream.unit5;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 554. 砖墙
 * @description https://leetcode-cn.com/problems/brick-wall/
 * @since 5/2/21 10:55 PM
 */
public class BrickWall {

    public static void main(String[] args) {
        /**
         * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
         * 输出：2
         */
        List<List<Integer>> wall1 = new ArrayList<>();
        wall1.add(Arrays.asList(1, 2, 2, 1));
        wall1.add(Arrays.asList(3, 1, 2));
        wall1.add(Arrays.asList(1, 3, 2));
        wall1.add(Arrays.asList(2, 4));
        wall1.add(Arrays.asList(3, 1, 2));
        wall1.add(Arrays.asList(1, 3, 1, 1));
        System.out.println(leastBricks(wall1));
        /**
         * 输入：wall = [[1],[1],[1]]
         * 输出：3
         */
        List<List<Integer>> wall2 = new ArrayList<>();
        wall2.add(Arrays.asList(1));
        wall2.add(Arrays.asList(1));
        wall2.add(Arrays.asList(1));
        System.out.println(leastBricks(wall2));
    }

    public static int leastBricks(List<List<Integer>> wall) {
        // key--到左边缘的距离 value--穿过砖块边缘的数量
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // 穿过砖块边缘的最大数量
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }

}
