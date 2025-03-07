package io.github.lgxkdream.test.other;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 归并排序
 * @description https://www.cnblogs.com/chengxiao/p/6194356.html
 * @since 2020-04-24 10:32
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 拆分成两半
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            // 比较合并
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 前半段有剩余
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 后半段有剩余
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 排好序后赋给原数组
        while (left <= right) {
            arr[left] = temp[left++];
        }
    }

}
