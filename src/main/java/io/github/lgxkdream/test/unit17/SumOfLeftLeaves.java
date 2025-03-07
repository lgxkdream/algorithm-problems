package io.github.lgxkdream.test.unit17;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 404. 左叶子之和
 * @description https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @since 2020-09-19 20:01
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);
        root.left = p1;
        root.right = p2;
        p2.left = p3;
        p2.right = p4;
        System.out.println(sumOfLeftLeaves(root));

        root = new TreeNode(1);
        System.out.println(sumOfLeftLeaves(root));
    }

    private static int sum;

    public static int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        sumOfLeftLeaves(root, false);
        return sum;
    }

    private static void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return;
        }
        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
    }

}
