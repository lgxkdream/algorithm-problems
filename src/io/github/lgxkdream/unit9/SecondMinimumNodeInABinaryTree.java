package io.github.lgxkdream.unit9;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 671. 二叉树中第二小的节点
 * @description https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * @since 2021-07-27 21:05
 */
public class SecondMinimumNodeInABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(5);
        TreeNode p3 = new TreeNode(5);
        TreeNode p4 = new TreeNode(7);
        root.left = p1;
        root.right = p2;
        p2.left = p3;
        p2.right = p4;
        /**
         * 输出：5
         * 解释：最小的值是 2 ，第二小的值是 5 。
         */
        System.out.println(findSecondMinimumValue(root));

        root = new TreeNode(2);
        p1 = new TreeNode(2);
        p2 = new TreeNode(2);
        root.left = p1;
        root.right = p2;
        /**
         * 输出：-1
         * 解释：最小的值是 2, 但是不存在第二小的值。
         */
        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int val) {
        if (node == null) {
            return -1;
        }
        if (node.val < val) {
            return val;
        }
        int l = dfs(node.left, val);
        int r = dfs(node.right, val);
        if (node.val < l && node.val < r) {
            return Math.min(l, r);
        }
        return Math.max(l, r);
    }

}
