package io.github.lgxkdream.unit4;

import java.util.TreeSet;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 220. 存在重复元素 III
 * @description https://leetcode-cn.com/problems/contains-duplicate-iii/
 * @since 4/17/21 9:37 PM
 */
public class ContainsDuplicateIII {

    public static void main(String[] args) {
        /**
         * 输出：true
         */
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        /**
         * 输出：true
         */
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        /**
         * 输出：false
         */
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    /**
     * nums[i] - nums[j] <= t   ==> nums[j] >= nums[i] - t
     * nums[i] - nums[j] >= -t  ==> nums[j] <= nums[i] + t
     * i - j <= k               j >=0 ==> i<=k
     * i - j >= -k              一定成立
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
