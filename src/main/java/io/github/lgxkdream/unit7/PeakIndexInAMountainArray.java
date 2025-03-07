package io.github.lgxkdream.unit7;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 852. 山脉数组的峰顶索引
 * @description https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * @since 6/15/21 11:18 PM
 */
public class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        /**
         * 输出：1
         */
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        /**
         * 输出：1
         */
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        /**
         * 输出：1
         */
        System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        /**
         * 输出：2
         */
        System.out.println(peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        /**
         * 输出：2
         */
        System.out.println(peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midRight = mid + 1;
            int midNum = arr[mid], midRightNum = arr[midRight];
            if (midNum < midRightNum) {
                left = midRight;
            } else if (midNum > midRightNum) {
                right = mid;
            }
        }
        return left;
    }

}
