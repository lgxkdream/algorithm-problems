package io.github.lgxkdream.test.unit15;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 110. 平衡二叉树
 * @description https://leetcode-cn.com/problems/balanced-binary-tree/
 * @since 2020-08-17 10:04
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        /**
         * 给定二叉树 [3,9,20,null,null,15,7]
         *
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         * 返回 true 。
         */
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(9);
        TreeNode r3 = new TreeNode(20);
        TreeNode r4 = new TreeNode(15);
        TreeNode r5 = new TreeNode(7);
        r1.left = r2;
        r1.right = r3;
        r3.left = r4;
        r3.right = r5;
        System.out.println(isBalanced1(r1));

        /**
         * 给定二叉树 [1,2,2,3,3,null,null,4,4]
         *
         *        1
         *       / \
         *      2   2
         *     / \
         *    3   3
         *   / \
         *  4   4
         * 返回 false 。
         */
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        System.out.println(isBalanced1(n1));
    }

    /**
     * 自底向上递归
     */
    public static boolean isBalanced1(TreeNode root) {
        return getHeight1(root) >= 0;
    }

    private static int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = getHeight1(root.left), rHeight = getHeight1(root.right);
        if (lHeight == -1 || rHeight == -1 || Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }
        return Math.max(lHeight, rHeight) + 1;
    }

    /**
     * 自顶向下递归
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
