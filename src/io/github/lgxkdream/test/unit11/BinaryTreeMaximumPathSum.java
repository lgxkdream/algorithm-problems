package io.github.lgxkdream.test.unit11;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 124. 二叉树中的最大路径和
 * @description https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @since 2020-06-21 09:38
 */
public class BinaryTreeMaximumPathSum {

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

    private static int maxPathSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxPathSum;
    }

    private static int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(getMaxPathSum(root.left), 0);
        int maxRight = Math.max(getMaxPathSum(root.right), 0);
        maxPathSum = Math.max(maxLeft + maxRight + root.val, maxPathSum);
        return Math.max(maxLeft, maxRight) + root.val;
    }

    // public static int maxPathSum(TreeNode root) {
    //     getMaxPathSum(root);
    //     return maxPathSum;
    // }

    // public static int getMaxPathSum(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftMax = getMaxPathSum(root.left);
    //     int rightMax = getMaxPathSum(root.right);
    //     int sum = root.val;
    //     if (leftMax > 0) {
    //         sum += leftMax;
    //     }
    //     if (rightMax > 0) {
    //         sum += rightMax;
    //     }
    //     maxPathSum = Math.max(sum, maxPathSum);
    //     return Math.max(Math.max(leftMax, rightMax), 0) + root.val;
    // }

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
            // int tempLeft = root.left.maxLeft > root.left.maxRight ? root.left.maxLeft : root.left.maxRight;
            root.maxLeft = Math.max(root.left.maxLeft, root.left.maxRight) + root.left.val;
        }
        if (root.right != null) {
            // int tempRight = root.right.maxLeft > root.right.maxRight ? root.right.maxLeft : root.right.maxRight;
            root.maxRight = Math.max(root.right.maxLeft, root.right.maxRight) + root.right.val;
        }
        maxPathSum = Math.max(maxPathSum, root.maxLeft + root.val + root.maxRight);
        // if (root.maxLeft + root.val + root.maxRight > maxPathSum) {
        //     maxPathSum = root.maxLeft + root.val + root.maxRight;
        // }
    }

}
