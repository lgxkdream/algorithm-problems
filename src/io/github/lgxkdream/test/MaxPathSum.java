package io.github.lgxkdream.test;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title: MaxPathSum
 * @description: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @Copyright: Copyright (c) 2019
 * @Company: lgxkdream.github.io
 * @since 2019-11-13 21:02
 */
public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);
        root.left = p1;
        root.right = p2;
        p2.left = p3;
        p2.right = p4;
        // answer: 42
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
//        getMaxPathSum1(root);
        getMaxPathSum(root);
        return maxPathSum;
    }

    static int maxPathSum = Integer.MIN_VALUE;

    private static int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(getMaxPathSum(root.left), 0);
        int maxRight = Math.max(getMaxPathSum(root.right), 0);
        maxPathSum = Math.max(maxLeft + maxRight + root.val, maxPathSum);
        return Math.max(maxLeft, maxRight) + root.val;
    }

    private static void getMaxPathSum1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            root.maxLeft = 0;
        }
        if (root.right == null) {
            root.maxRight = 0;
        }
        if (root.left != null) {
            getMaxPathSum(root.left);
        }
        if (root.right != null) {
            getMaxPathSum(root.right);
        }
        if (root.left != null) {
            int tempLeft = root.left.maxLeft > root.left.maxRight ? root.left.maxLeft : root.left.maxRight;
            root.maxLeft = tempLeft + root.left.val;
        }
        if (root.right != null) {
            int tempRight = root.right.maxLeft > root.right.maxRight ? root.right.maxLeft : root.right.maxRight;
            root.maxRight = tempRight + root.right.val;
        }
        if (root.maxLeft + root.val + root.maxRight > maxPathSum) {
            maxPathSum = root.maxLeft + root.val + root.maxRight;
        }
    }

}