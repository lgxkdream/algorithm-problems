package io.github.lgxkdream.test.unit10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 739. 每日温度
 * @description https://leetcode-cn.com/problems/daily-temperatures/
 * @since 2020-06-11 10:24
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        /**
         * 输出：[1, 1, 4, 2, 1, 1, 0, 0]
         */
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    /**
     * 单调栈思想
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

}
