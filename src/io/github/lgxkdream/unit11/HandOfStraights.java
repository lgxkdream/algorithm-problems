package io.github.lgxkdream.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 846. 一手顺子
 * @description https://leetcode-cn.com/problems/hand-of-straights/
 * @since 2021-12-30 21:47
 */
public class HandOfStraights {

    public static void main(String[] args) {
        /**
         * 输出：true
         * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
         */
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        /**
         * 输出：false
         * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
         */
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        return false;
    }

}
