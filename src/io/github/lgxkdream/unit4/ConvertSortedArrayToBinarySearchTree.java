package io.github.lgxkdream.unit4;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title: 108. 将有序数组转换为二叉搜索树
 * @description: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @Copyright: Copyright (c) 2019
 * @company: lgxkdream.github.io
 * @since 2020年7月3日 下午09:29:18
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

}
