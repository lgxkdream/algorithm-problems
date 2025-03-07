package io.github.lgxkdream.unit11;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 563. 二叉树的坡度
 * @description https://leetcode-cn.com/problems/binary-tree-tilt/
 * @since 11/18/21 11:12 PM
 */
public class BinaryTreeTilt {

    public static void main(String[] args) {

    }

    private static int res;

    public static int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        res += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }

}
