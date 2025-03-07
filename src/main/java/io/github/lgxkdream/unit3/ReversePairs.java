package io.github.lgxkdream.unit3;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 面试题51. 数组中的逆序对
 * @description https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @since 2020-04-24 09:57
 */
public class ReversePairs {

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        // int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(reversePairs(nums)); // 5
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序思想
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1, temp);
    }

    private static int reversePairs(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(arr, left, mid, temp);
        int rightCount = reversePairs(arr, mid + 1, right, temp);
        if (arr[mid] <= arr[mid + 1]) {
            return leftCount + rightCount;
        }
        int curCount = reversePairs(arr, left, mid, right, temp);
        return leftCount + rightCount + curCount;
    }

    private static int reversePairs(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        int result = 0;
        for (int k = left; k < right + 1; k++) {
            if (i > mid) {
                temp[k] = arr[j++];
            } else if (j > right) {
                temp[k] = arr[i++];
            } else if (arr[i] <= arr[j]) {
                temp[k] = arr[i++];
            } else {
                result = result + mid - i + 1;
                temp[k] = arr[j++];
            }
        }
        while (left <= right) {
            arr[left] = temp[left++];
        }
        return result;
    }

}
