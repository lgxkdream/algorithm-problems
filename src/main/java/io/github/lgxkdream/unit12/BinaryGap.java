package io.github.lgxkdream.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 868. 二进制间距
 * @description https://leetcode-cn.com/problems/binary-gap/
 * @since 4/24/22 8:23 AM
 */
public class BinaryGap {

    public static void main(String[] args) {
        /**
         * 输出：2
         * 解释：22 的二进制是 "10110" 。
         * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
         * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
         * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
         * 答案取两个距离之中最大的，也就是 2 。
         */
        System.out.println(binaryGap(22));
        /**
         * 输出：0
         * 解释：8 的二进制是 "1000" 。
         * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
         */
        System.out.println(binaryGap(8));
        /**
         * 输出：2
         * 解释：5 的二进制是 "101" 。
         */
        System.out.println(binaryGap(5));
    }

    public static int binaryGap(int n) {
        int res = 0;
        int idx = 0, lastIdx = -1;
        while (n != 0) {
            if (lastIdx != -1) {
                res = Math.max(res, idx - lastIdx);
            }
            if ((n & 1) != 0) {
                lastIdx = idx;
            }
            idx++;
            n >>= 1;
        }
        return res;
    }

}
