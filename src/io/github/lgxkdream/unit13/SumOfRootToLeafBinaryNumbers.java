package io.github.lgxkdream.unit13;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1022. 从根到叶的二进制数之和
 * @description https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 * @since 2022-05-30 21:38
 */
public class SumOfRootToLeafBinaryNumbers {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(0, new TreeNode(0), new TreeNode(1));
        TreeNode p2 = new TreeNode(1, new TreeNode(0), new TreeNode(1));
        TreeNode root = new TreeNode(1, p1, p2);
        /**
         * 输出：22
         * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
         */
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val << 1 | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }

}
