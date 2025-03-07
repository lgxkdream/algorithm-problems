package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title: MaxDistance(二叉树两叶节点的最大距离)
 * @description: 给定一棵二叉树，计算这课二叉树的直径长度，即为二叉树任意两个节点间的最长路径。比如：
 *                    1
 *                   / \
 *                  2   3
 *                 / \
 *                4  5
 * 这棵二叉树的最长路径为3。
 * @Copyright: Copyright (c) 2019
 * @Company: lgxkdream.github.io
 * @since 2019年11月13日 下午5:29:00
 */
public class MaxDistance {

    static int maxLen = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(8);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p3.left = p4;
        p2.left = p5;
        p2.right = p6;
        p6.right = p7;
        p7.right = p8;
        FindMaxLen(root);
//        FindMaxLen1(root);
        System.out.println(maxLen);
    }

    public static void FindMaxLen(TreeNode pRoot) {
        if (pRoot == null) {
            // 空的话直接结束
            return;
        }
        if (pRoot.left == null) {
            // 左子为空，左面最大长度为0
            pRoot.maxLeft = 0;
        }
        if (pRoot.right == null) {
            // 右子为空，右面最大长度为0
            pRoot.maxRight = 0;
        }
        if (pRoot.left != null) {
            // 递归获取以左子节点为根节点的最大距离
            FindMaxLen(pRoot.left);
        }
        if (pRoot.right != null) {
            // 递归获取以右子节点为根节点的最大距离
            FindMaxLen(pRoot.right);
        }
        if (pRoot.left != null) {
            // 左面最大距离=左子左面最大距离与左子右面最大距离取最大值+1
            pRoot.maxLeft = Math.max(pRoot.left.maxLeft, pRoot.left.maxRight) + 1;
        }
        if (pRoot.right != null) {
            // 右面最大距离=右子左面最大距离与右子右面最大距离取最大值+1
            pRoot.maxRight = Math.max(pRoot.right.maxLeft, pRoot.right.maxRight) + 1;
        }
        if (pRoot.maxLeft + pRoot.maxRight > maxLen) {
            // 刷新最大距离
            maxLen = pRoot.maxLeft + pRoot.maxRight;
        }
    }

    public static int FindMaxLen1(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        // 递归获取左子、右子的最大距离
        int maxLeft = FindMaxLen1(pRoot.left);
        int maxRight = FindMaxLen1(pRoot.right);
        // 刷新最大距离
        maxLen = Math.max(maxLeft + maxRight, maxLen);
        // 返回该节点的父节点在该侧的最大距离
        return Math.max(maxLeft, maxRight) + 1;
    }

}
