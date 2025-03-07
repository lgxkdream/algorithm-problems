package io.github.lgxkdream.test.other;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title: TrappingRainWaterTest
 * @description:
 * @Copyright: Copyright (c) 2019
 * @company: lgxkdream.github.io
 * @since 2019年3月4日 下午2:19:14
 */
public class TrappingRainWaterTest {

    public static void main(String[] args) {
        int[] water = {20, 8, 4, 6, 3, 9, 5, 10, 7, 11};
        // 36
        System.out.println(getWater(water));
        System.out.println(getWater1(water));
    }

    private static int getWater(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int sum = 0, l = 1, r = arr.length - 2;
        int leftMax = arr[0], rightMax = arr[arr.length - 1];
        while (l <= r) {
            if (leftMax < rightMax) {
                sum += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                sum += Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return sum;
    }

    private static int getWater1(int[] arr) {
        int res = 0;
        int l = 0, r = arr.length - 1, level = 0;
        while (l < r) {
            int lower = arr[arr[l] < arr[r] ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        return res;
    }

}
