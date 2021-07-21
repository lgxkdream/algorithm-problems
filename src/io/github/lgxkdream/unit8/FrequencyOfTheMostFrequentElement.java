package io.github.lgxkdream.unit8;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1838. 最高频元素的频数
 * @description https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 * @since 2021-07-21 21:09
 */
public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        /**
         * 输出：3
         * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
         * 4 是数组中最高频元素，频数是 3 。
         */
//        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
        /**
         * 输出：2
         * 解释：存在多种最优解决方案：
         * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
         * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
         * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
         */
//        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));
        /**
         * 输出：1
         */
        System.out.println(maxFrequency(new int[]{3, 9, 6}, 2));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int left = 0, right = 1;
        while (right < nums.length) {
            res = Math.max(res, right - left);
            int need = (nums[right + 1] - nums[right]) * (right - left + 1);
            if (need <= k) {
                k -= need;
                right++;
            } else {
                k += (nums[right] - nums[left]);
                if (left++ > right) {
                    right++;
                }
            }
        }
        return res;
    }

}
