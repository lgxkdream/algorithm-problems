package io.github.lgxkdream.test.unit11;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 16. 最接近的三数之和
 * @description
 * @since 2020-06-24 19:18
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        /**
         * 输出：2
         * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
         */
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i], l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = num + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                }
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    closestSum = sum;
                    diff = newDiff;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closestSum;
    }

}
