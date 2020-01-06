package io.github.lgxkdream.test;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title: MyTest
 * @description:
 * @Copyright: Copyright (c) 2019
 * @Company: lgxkdream.github.io
 * @since 2019-10-28 20:51
 */
public class MaxDistanceTest {

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
