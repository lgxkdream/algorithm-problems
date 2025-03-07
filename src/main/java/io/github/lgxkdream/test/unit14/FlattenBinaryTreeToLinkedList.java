package io.github.lgxkdream.test.unit14;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 114. 二叉树展开为链表
 * @description https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @since 2020-08-02 09:55
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        /**
         * 例如，给定二叉树
         *
         *     1
         *    / \
         *   2   5
         *  / \   \
         * 3   4   6
         * 将其展开为：
         *
         * 1
         *  \
         *   2
         *    \
         *     3
         *      \
         *       4
         *        \
         *         5
         *          \
         *           6
         *
         */
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        p1.left = p2;
        p1.right = p5;
        p2.left = p3;
        p2.right = p4;
        p5.right = p6;

        flatten(p1);
        while (p1 != null) {
            System.out.println(p1.val);
            p1 = p1.right;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }

}
