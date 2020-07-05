package io.github.lgxkdream.test.unit9;

import io.github.lgxkdream.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 对称二叉树
 * @description https://leetcode-cn.com/problems/symmetric-tree/
 * @since 2020-05-31 09:30
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);

        node1.left = node21;
        node1.right = node22;
        node21.left = node31;
        node21.right = node41;
        node22.left = node42;
        node22.right = node32;
        System.out.println(isSymmetric(node1));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    private static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric1(root.left, root.right);
    }

    private static boolean isSymmetric1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetric1(left.left, right.right) && isSymmetric1(left.right, right.left);
    }

}
