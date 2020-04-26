package io.github.lgxkdream.test.unit4;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Trap
 * @description https://leetcode-cn.com/problems/trapping-rain-water/
 * @since 2020-04-04 12:23
 */
public class Trap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int result = 0;
        int left = 1, right = height.length - 2, leftMax = height[0], rightMax = height[height.length - 1];
        while (left <= right) {
            if (leftMax < rightMax) {
                result += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                result += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return result;
    }

}
