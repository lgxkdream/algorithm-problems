package io.github.lgxkdream.test.unit18;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title HouseRobberII
 * @description
 * @since 2021-04-15 22:12
 */
public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1};
        System.out.println(rob(nums));
        nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
        nums = new int[]{0};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int preMax = 0, curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        int firstMax = curMax;
        preMax = 0;
        curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        return Math.max(firstMax, curMax);
    }

}
