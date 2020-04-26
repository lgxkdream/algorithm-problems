package io.github.lgxkdream.test.unit2;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test0318
 * @description
 * @since 2020-03-18 16:40
 */
public class Test0318 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

}
