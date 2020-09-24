package io.github.lgxkdream.test.unit18;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 501. 二叉搜索树中的众数
 * @description https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * @since 2020-09-24 10:30
 */
public class FindModeInBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(2);
        root.right = p1;
        p1.left = p2;
    }

    public static int[] findMode(TreeNode root) {
        return null;
    }

}
