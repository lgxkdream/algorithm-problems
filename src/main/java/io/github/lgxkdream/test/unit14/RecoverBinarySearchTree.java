package io.github.lgxkdream.test.unit14;

import io.github.lgxkdream.common.TreeNode;
import io.github.lgxkdream.unit2.BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 99. 恢复二叉搜索树
 * @description https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @since 2020-08-08 12:56
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(2);
        root.left = p1;
        p1.right = p2;
        // recoverTree(root);
        recoverTree1(root);
        List<List<Integer>> lists = BinaryTreeLevelOrderTraversal.levelOrder1(root);
        System.out.println(lists);
    }

    /**
     * 中序遍历思想，找出逆序节点，如果只有一对，则直接交换，如果有两对，则第一对的第一个节点和第二对的第二个节点交换
     *
     * @param root
     */
    public static void recoverTree1(TreeNode root) {
        TreeNode pre = null, n1 = null, n2 = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                if (pre != null && pre.val > pop.val) {
                    if (n1 == null) {
                        n1 = pre;
                    }
                    n2 = pop;
                }
                pre = pop;
                root = pop.right;
            }
        }
        swap(n1, n2);
    }

    /**
     * 交换
     *
     * @param n1
     * @param n2
     */
    private static void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private static TreeNode pre, n1, n2;

    public static void recoverTree(TreeNode root) {
        inorder(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (n1 == null) {
                n1 = pre;
            }
            n2 = root;
        }
        pre = root;
        inorder(root.right);
    }

}
