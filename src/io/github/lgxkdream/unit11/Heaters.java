package io.github.lgxkdream.unit11;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 475. 供暖器
 * @description https://leetcode-cn.com/problems/heaters/
 * @since 12/20/21 10:55 PM
 */
public class Heaters {

    public static void main(String[] args) {
        /**
         * 输出: 1
         * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
         */
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        /**
         * 输出: 1
         * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
         */
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        /**
         * 输出: 3
         */
        System.out.println(findRadius(new int[]{1, 5}, new int[]{2}));
    }

    /**
     * 双指针
     */
    public static int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            int cur = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                cur = Math.min(cur, Math.abs(houses[i] - heaters[j]));
            }
            res = Math.max(res, cur);
        }
        return res;
    }

}
