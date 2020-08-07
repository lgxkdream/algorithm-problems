package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 100. 相同的树
 * @description https://leetcode-cn.com/problems/same-tree/
 * @since 2020-08-07 09:53
 */
public class SameTree {

    public static void main(String[] args) {
        /**
         * 输入:       1         1
         *           / \       / \
         *          2   3     2   3
         *
         *         [1,2,3],   [1,2,3]
         *
         * 输出: true
         */
        TreeNode r001 = new TreeNode(1);
        TreeNode n011 = new TreeNode(2);
        TreeNode n021 = new TreeNode(3);
        r001.left = n011;
        r001.right = n021;
        TreeNode r002 = new TreeNode(1);
        TreeNode n012 = new TreeNode(2);
        TreeNode n022 = new TreeNode(3);
        r002.left = n012;
        r002.right = n022;
        System.out.println(isSameTree(r001, r002));

        /**
         * 输入:      1          1
         *           /           \
         *          2             2
         *
         *         [1,2],     [1,null,2]
         *
         * 输出: false
         */
        TreeNode r101 = new TreeNode(1);
        TreeNode n111 = new TreeNode(2);
        r101.left = n111;
        TreeNode r102 = new TreeNode(1);
        TreeNode n112 = new TreeNode(2);
        r102.right = n112;
        System.out.println(isSameTree(r101, r102));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

}
