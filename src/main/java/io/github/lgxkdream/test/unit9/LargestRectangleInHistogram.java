package io.github.lgxkdream.test.unit9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 柱状图中最大的矩形
 * @description https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @since 2020-05-30 14:03
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        /**
         * 输出: 10
         */
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        /**
         * 输出: 9
         */
        System.out.println(largestRectangleArea(new int[]{0, 9}));
        /**
         * 输出: 2
         */
        System.out.println(largestRectangleArea(new int[]{1, 1}));
        /**
         * 输出: 3
         */
        System.out.println(largestRectangleArea(new int[]{2, 1, 2}));
    }

    /**
     * 单调栈 + 常数优化
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        heights = newHeights;
        len += 2;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int result = 0;
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                result = Math.max(result, height * width);
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 暴力解法
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return heights[0];
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int left = i, right = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            while (right < length - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }
            result = Math.max(result, (right - left + 1) * heights[i]);
        }
        return result;
    }

}
