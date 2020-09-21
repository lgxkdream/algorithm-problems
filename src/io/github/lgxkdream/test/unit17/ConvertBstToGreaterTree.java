package io.github.lgxkdream.test.unit17;

import io.github.lgxkdream.common.TreeNode;
import io.github.lgxkdream.unit2.BinaryTreeLevelOrderTraversal;

import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 538. 把二叉搜索树转换为累加树
 * @description https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @since 2020-09-21 14:37
 */
public class ConvertBstToGreaterTree {

    public static void main(String[] args) {
        /**
         * 输入: 原始二叉搜索树:
         *               5
         *             /   \
         *            2     13
         *
         * 输出: 转换为累加树:
         *              18
         *             /   \
         *           20     13
         */
        TreeNode root = new TreeNode(5);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(13);
        root.left = p1;
        root.right = p2;
        TreeNode node = convertBST(root);
        List<List<Integer>> lists = BinaryTreeLevelOrderTraversal.levelOrder1(node);
        System.out.println(lists);
    }

    public static TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private static int sum = 0;

    private static void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }

}
