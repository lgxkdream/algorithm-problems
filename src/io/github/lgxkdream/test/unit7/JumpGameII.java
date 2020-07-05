package io.github.lgxkdream.test.unit7;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 跳跃游戏 II
 * @description https://leetcode-cn.com/problems/jump-game-ii/
 * @since 2020-05-04 09:01
 */
public class JumpGameII {

    public static void main(String[] args) {
        // int[] nums = {2, 3, 1, 1, 4}; // 2
        // int[] nums = {2, 4, 1, 1, 3, 2, 1}; // 3
        int[] nums = {1, 2, 5, 1, 1, 1, 2, 0, 1, 0}; // 5
        // int[] nums = {2, 1}; // 1
        /**
         * 输出: 2
         * 解释: 跳到最后一个位置的最小跳跃数是 2。
         *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
         */
        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int result = 0, end = 0, maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                result++;
            }
        }
        return result;
    }


    private static int jump1(int[] nums) {
        // 记录上一步能跳到的最远位置。
        int end = 0;
        // 最远可以跳到的位置。
        int maxPosition = 0;
        int steps = 0;
        // 从起点开始循环起跳，到达最终位置以后不再起跳。
        // 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录当前一步可以跳到的最远位置。
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 判断是否到达上一步能跳到的最远位置。
            if (i == end) {
                // 记录当前一步能跳到的最远位置。
                end = maxPosition;
                steps++;
            }
            System.out.println(end + " " + maxPosition + " " + steps);
        }
        return steps;
    }

    /**
     * nums = {2, 4, 1, 1, 3, 2, 1};
     *
     * i  end  maxPosition  steps
     * 0  2    0+2=2         1
     * 1  2    1+4=5         1
     * 2  5    5             2
     * 3  5    5             2
     * 4  5    4+3=7         2
     * 5  7    7             3
     * 6
     */

}
