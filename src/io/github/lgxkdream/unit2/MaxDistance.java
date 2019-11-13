package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.TreeNode;

/**
 * @title: MaxDistance(二叉树两叶节点的最大距离)
 * @description: 给定一棵二叉树，计算这课二叉树的直径长度，即为二叉树任意两个节点间的最长路径。比如：
                     1
                    / \
                   2   3
                  / \
                 4  5
                 这棵二叉树的最长路径为3。
 * @Copyright: Copyright (c) 2019
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
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
        System.out.println(maxLen);
    }

    public static void FindMaxLen(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        if (pRoot.left == null) {
            pRoot.maxLeft = 0;
        }
        if (pRoot.right == null) {
            pRoot.maxRight = 0;
        }
        if (pRoot.left != null) {
            FindMaxLen(pRoot.left);
        }
        if (pRoot.right != null) {
            FindMaxLen(pRoot.right);
        }
        if (pRoot.left != null) {
            int nTempLeft = pRoot.left.maxLeft > pRoot.left.maxRight ? pRoot.left.maxLeft : pRoot.left.maxRight;
            pRoot.maxLeft = nTempLeft + 1;
        }
        if (pRoot.right != null) {
            int nTempRight = pRoot.right.maxLeft > pRoot.right.maxRight ? pRoot.right.maxLeft : pRoot.right.maxRight;
            pRoot.maxRight = nTempRight + 1;
        }
        if (pRoot.maxLeft + pRoot.maxRight > maxLen) {
            maxLen = pRoot.maxLeft + pRoot.maxRight;
        }
    }

}
