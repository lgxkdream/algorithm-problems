package io.github.lgxkdream.unit2;

/**
 * 
 * @title: MergeSortedArray(合并两个有序数组)
 * @description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
                 说明:
                 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
                 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
                 示例:
                 输入:
                 nums1 = [1,2,3,0,0,0], m = 3
                 nums2 = [2,5,6],       n = 3
                 输出: [1,2,2,3,5,6]
 * @Copyright: Copyright (c) 2019
 * @company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2019年1月23日 上午10:59:45
 */
public class MergeSortedArray {
	
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		merge(nums1, m, nums2, n);
		for (int num : nums1) {
			System.out.println(num);
		}
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int total = m + n;
		while (m > 0 && n > 0) { // 从后向前比较nums1和nums2大小
			if (nums1[m - 1] >= nums2[n - 1]) {
				nums1[--total] = nums1[--m];
			} else {
				nums1[--total] = nums2[--n];
			}
		}
		while (n > 0) { // 如果n先到达0就能直接得到合并好的数组；如果m先到达0，只需将n剩下的元素复制到nums1中即可
			nums1[--total] = nums2[--n];
		}
	}

}
