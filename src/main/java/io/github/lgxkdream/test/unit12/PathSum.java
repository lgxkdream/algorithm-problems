package io.github.lgxkdream.test.unit12;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 112. 路径总和
 * @description https://leetcode-cn.com/problems/path-sum/
 * @since 2020-07-07 22:28
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p1 = new TreeNode(4);
        TreeNode p2 = new TreeNode(8);
        TreeNode p3 = new TreeNode(11);
        TreeNode p4 = new TreeNode(13);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(7);
        TreeNode p7 = new TreeNode(2);
        TreeNode p8 = new TreeNode(1);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;
        p5.right = p8;
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (root.left == null && root.right == null && val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - val) || hasPathSum(root.right, sum - val);
    }

}
