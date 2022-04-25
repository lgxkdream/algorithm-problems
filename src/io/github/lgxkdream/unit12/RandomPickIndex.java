package io.github.lgxkdream.unit12;

import java.util.Random;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 398. 随机数索引
 * @description
 * @since 2022-04-25 13:39
 */
public class RandomPickIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);

        // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
        System.out.println(solution.pick(3));;

        // pick(1) 应该返回 0。因为只有nums[0]等于1。
        System.out.println(solution.pick(1));;
    }

}

class Solution {

    private int[] nums;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = 0;
        int cou = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                cou++;
                if (random.nextInt(cou) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
