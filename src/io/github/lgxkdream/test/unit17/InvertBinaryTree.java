package io.github.lgxkdream.test.unit17;

import io.github.lgxkdream.common.TreeNode;
import io.github.lgxkdream.unit2.BinaryTreeLevelOrderTraversal;

import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 226. 翻转二叉树
 * @description https://leetcode-cn.com/problems/invert-binary-tree/
 * @since 2020-09-16 22:56
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(7);
        TreeNode p3 = new TreeNode(1);
        TreeNode p4 = new TreeNode(3);
        TreeNode p5 = new TreeNode(6);
        TreeNode p6 = new TreeNode(9);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p1.right = p4;
        p2.left = p5;
        p2.right = p6;
        root = invertTree(root);
        List<List<Integer>> lists = BinaryTreeLevelOrderTraversal.levelOrder1(root);
        /**
         * 输入：
         *
         *      4
         *    /   \
         *   2     7
         *  / \   / \
         * 1   3 6   9
         * 输出：
         *
         *      4
         *    /   \
         *   7     2
         *  / \   / \
         * 9   6 3   1
         */
        System.out.println(lists);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
