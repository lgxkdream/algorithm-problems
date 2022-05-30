package io.github.lgxkdream.test.unit13;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 08.03. 魔术索引
 * @description https://leetcode-cn.com/problems/magic-index-lcci/
 * @since 2020-07-31 19:42
 */
public class MagicIndexLcci {

    public static void main(String[] args) {
        /**
         * 输出：0
         * 说明: 0下标的元素为0
         */
        System.out.println(findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        /**
         * 输出：1
         */
        System.out.println(findMagicIndex(new int[]{1, 1, 1}));
    }

    public static int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i = Math.max(nums[i], i + 1)) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

}
