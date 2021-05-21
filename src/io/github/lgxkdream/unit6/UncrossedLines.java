package io.github.lgxkdream.unit6;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1035. 不相交的线
 * @description https://leetcode-cn.com/problems/uncrossed-lines/
 * @since 2021-05-21 21:54
 */
public class UncrossedLines {

    public static void main(String[] args) {
        /**
         * 输出：2
         * 解释：可以画出两条不交叉的线，如上图所示。
         * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
         */
        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        /**
         * 输出：3
         */
        System.out.println(maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        /**
         * 输出：2
         */
        System.out.println(maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        return 0;
    }

}
