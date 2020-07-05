package io.github.lgxkdream.test.unit8;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 寻找两个正序数组的中位数
 * @description https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @since 2020-05-24 08:46
 */
public class MedianOfTwoSortedArrays {

    // TODO 隔一段时间重新练习
    public static void main(String[] args) {
        /**
         * 中位数是 2.0
         */
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

        /**
         * 中位数是(2 + 3) / 2 = 2.5
         */
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLeft = (len1 + len2 + 1) / 2;
        int left = 0, right = len1;
        // nums1[i-1] <= nums2[j] && nums1[i] >= nums2[j-1]
        while (left < right) {
            // 代表nums1右半段的第一个元素
            int i = (left + right + 1) / 2;
            // 代表nums2右半段的第一个元素
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int nums1LeftMax = left == 0 ? Integer.MIN_VALUE : nums1[left - 1];
        int nums1RightMin = left == len1 ? Integer.MAX_VALUE : nums1[left];
        int nums2LeftMax = totalLeft - left == 0 ? Integer.MIN_VALUE : nums2[totalLeft - left - 1];
        int nums2LeftMin = totalLeft - left == len2 ? Integer.MAX_VALUE : nums2[totalLeft - left];
        int numsLeftMax = Math.max(nums1LeftMax, nums2LeftMax);
        int numsRightMin = Math.min(nums1RightMin, nums2LeftMin);
        return (len1 + len2) % 2 == 0 ? (double) (numsLeftMax + numsRightMin) / 2 : numsLeftMax;
    }

}
