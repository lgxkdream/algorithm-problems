package io.github.lgxkdream.unit8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1893. 检查是否区域内所有整数都被覆盖
 * @description
 * @since 7/23/21 9:01 PM
 */
public class IsCovered {

    public static void main(String[] args) {
        System.out.println(isCovered(new int[][]{{3, 4}, {1, 2}, {5, 6}}, 2, 5));
        System.out.println(isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
        System.out.println(isCovered(new int[][]{{1, 50}}, 1, 50));
        System.out.println(isCovered(new int[][]{{37, 49}, {5, 17}, {8, 32}}, 29, 49));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                map.put(i, true);
            }
        }
        for (int i = left; i <= right; i++) {
            if (map.getOrDefault(i, false) == false) {
                return false;
            }
        }
        return true;
    }

}
