package io.github.lgxkdream.unit6;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1738. 找出第 K 大的异或坐标值
 * @description https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 * @since 2021-05-19 21:45
 */
public class FindKthLargestXorCoordinateValue {

    public static void main(String[] args) {
        /**
         * 输出：7
         * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        /**
         * 输出：5
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        /**
         * 输出：4
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
        /**
         * 输出：0
         */
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        return 0;
    }

}
