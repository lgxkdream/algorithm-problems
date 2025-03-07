package io.github.lgxkdream.test.unit8;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 寻找重复数
 * @description https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @since 2020-05-26 10:19
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        /**
         * 输出: 2
         */
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));

        /**
         * 输出: 3
         */
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    /**
     * a b
     * f = 2s = s + nb -> s = nb
     * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     * 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     * 即按照寻找链表环入口的思路来做
     **/
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                break;
            }
        }
        return slow;
    }

}
