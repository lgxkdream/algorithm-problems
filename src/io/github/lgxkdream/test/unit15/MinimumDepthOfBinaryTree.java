package io.github.lgxkdream.test.unit15;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 111. 二叉树的最小深度
 * @description https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @since 2020-08-21 19:43
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        /**
         * 给定二叉树 [3,9,20,null,null,15,7],
         *
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         * 返回它的最小深度  2.
         */
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(20);
        TreeNode p4 = new TreeNode(15);
        TreeNode p5 = new TreeNode(7);
        p1.left = p2;
        p1.right = p3;
        p3.left = p4;
        p3.right = p5;
        System.out.println(minDepth(p1));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            int leftMinDepth = minDepth(root.left);
            int rightMinDepth = minDepth(root.right);
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        }
        if (root.left != null) {
            return minDepth(root.left) + 1;
        } else {
            return minDepth(root.right) + 1;
        }
    }

}
