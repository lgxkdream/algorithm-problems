package io.github.lgxkdream.test.unit13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 350. 两个数组的交集 II
 * @description https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @since 2020-07-13 22:21
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        /**
         * 输出：[2,2]
         */
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        /**
         * 输出：[4,9]
         */
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int idx1 = nums1.length - 1, idx2 = nums2.length - 1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        while (idx1 >= 0 && idx2 >= 0) {
            if (nums1[idx1] > nums2[idx2]) {
                idx1--;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx2--;
            } else {
                list.add(nums1[idx1]);
                idx1--;
                idx2--;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}
