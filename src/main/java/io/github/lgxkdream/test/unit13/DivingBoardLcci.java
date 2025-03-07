package io.github.lgxkdream.test.unit13;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 16.11. 跳水板
 * @description https://leetcode-cn.com/problems/diving-board-lcci/
 * @since 2020-07-08 23:05
 */
public class DivingBoardLcci {

    public static void main(String[] args) {
        /**
         * 输出： {3,4,5,6}
         */
        System.out.println(Arrays.toString(divingBoard(1, 2, 3)));
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] result = new int[k + 1];
        int min = shorter * k, max = longer * k, diff = longer - shorter, i = 0;
        while (min <= max) {
            result[i++] = min;
            min += diff;
        }
        return result;
    }

}
