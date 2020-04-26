package io.github.lgxkdream.test.unit5;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title ContainerWithMostWater
 * @description https://leetcode-cn.com/problems/container-with-most-water/
 * @since 2020-04-18 11:33
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int curHeight;
        int result = 0;
        while (left < right) {
            int curLength = right - left;
            if (height[left] < height[right]) {
                curHeight = height[left++];
            } else {
                curHeight = height[right--];
            }
            result = Math.max(result, curHeight * curLength);
        }
        return result;
    }

}
