package io.github.lgxkdream.unit9;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 881. 救生艇
 * @description https://leetcode-cn.com/problems/boats-to-save-people/
 * @since 2021-08-26 20:37
 */
public class BoatsToSavePeople {

    public static void main(String[] args) {
        /**
         * 输出：1
         * 解释：1 艘船载 (1, 2)
         */
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));
        /**
         * 输出：3
         * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
         */
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        /**
         * 输入：people = [3,5,3,4], limit = 5
         * 输出：4
         * 解释：4 艘船分别载 (3), (3), (4), (5)
         */
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            res++;
        }
        return res;
    }

}
