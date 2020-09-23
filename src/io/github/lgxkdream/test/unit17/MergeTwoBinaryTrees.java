package io.github.lgxkdream.test.unit17;

import io.github.lgxkdream.common.TreeNode;
import io.github.lgxkdream.unit2.BinaryTreeLevelOrderTraversal;

import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 617. 合并二叉树
 * @description https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @since 2020-09-23 19:49
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        /**
         * 输入:
         * 	Tree 1                     Tree 2
         *           1                         2
         *          / \                       / \
         *         3   2                     1   3
         *        /                           \   \
         *       5                             4   7
         * 输出:
         * 合并后的树:
         * 	     3
         * 	    / \
         * 	   4   5
         * 	  / \   \
         * 	 5   4   7
         */
        TreeNode root1 = new TreeNode(1);
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(5);
        root1.left = p1;
        root1.right = p2;
        p1.left = p3;
        TreeNode root2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(7);
        root2.left = n1;
        root2.right = n2;
        n1.right = n3;
        n2.right = n4;

        TreeNode root = mergeTrees1(root1, root2);
        List<List<Integer>> lists = BinaryTreeLevelOrderTraversal.levelOrder1(root);
        System.out.println(lists);
    }

    public static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees1(t1.left, t2.left);
        root.right = mergeTrees1(t1.right, t2.right);
        return root;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val;
        TreeNode left, right;
        if (t1 == null) {
            val = t2.val;
            left = mergeTrees(null, t2.left);
            right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            val = t1.val;
            left = mergeTrees(t1.left, null);
            right = mergeTrees(t1.right, null);
        } else {
            val = t1.val + t2.val;
            left = mergeTrees(t1.left, t2.left);
            right = mergeTrees(t1.right, t2.right);
        }
        TreeNode root = new TreeNode();
        root.val = val;
        root.left = left;
        root.right = right;
        return root;
    }

}
