package io.github.lgxkdream.test.unit3;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title DiameterOfBinaryTree
 * @description
 * @since 2020-03-27 11:15
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        // TreeNode p6 = new TreeNode(6);
        // TreeNode p7 = new TreeNode(7);
        // TreeNode p8 = new TreeNode(8);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        System.out.println(diameterOfBinaryTree(p1));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return result;
    }

    static int result = 0;

    private static int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = maxLength(root.left);
        int rMax = maxLength(root.right);
        result = Math.max(result, lMax + rMax);
        return Math.max(lMax, rMax) + 1;
    }

}
