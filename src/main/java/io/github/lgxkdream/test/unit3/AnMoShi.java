package io.github.lgxkdream.test.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title AnMoShi
 * @description
 * @since 2020-03-24 09:54
 */
public class AnMoShi {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(massage(nums));
    }

    public static int massage(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int nextMax = Math.max(preMax + nums[i], curMax);
            preMax = curMax;
            curMax = nextMax;

        }
        return curMax;
    }

}
