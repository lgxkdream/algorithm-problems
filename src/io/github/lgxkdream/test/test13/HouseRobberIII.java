package io.github.lgxkdream.test.test13;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 337. 打家劫舍 III
 * @description https://leetcode-cn.com/problems/house-robber-iii/
 * @since 2020-08-04 22:24
 */
public class HouseRobberIII {

    public static void main(String[] args) {
        /**
         * 输入: [3,2,3,null,3,null,1
         *
         *      3
         *     / \
         *    2   3
         *     \   \
         *      3   1
         *
         * 输出: 7
         * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
         */
        TreeNode p00 = new TreeNode(3);
        TreeNode p01 = new TreeNode(2);
        TreeNode p02 = new TreeNode(3);
        TreeNode p03 = new TreeNode(3);
        TreeNode p04 = new TreeNode(1);
        p00.left = p01;
        p00.right = p02;
        p01.right = p03;
        p02.right = p04;
        System.out.println(rob(p00));

        /**
         * 输入: [3,4,5,1,3,null,1]
         *
         *      3
         *     / \
         *    4   5
         *   / \   \
         *  1   3   1
         *
         * 输出: 9
         * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
         */
        TreeNode p10 = new TreeNode(3);
        TreeNode p11 = new TreeNode(4);
        TreeNode p12 = new TreeNode(5);
        TreeNode p13 = new TreeNode(1);
        TreeNode p14 = new TreeNode(3);
        TreeNode p15 = new TreeNode(1);
        p10.left = p11;
        p10.right = p12;
        p11.left = p13;
        p11.right = p14;
        p12.right = p15;
        System.out.println(rob(p10));
    }

    /**
     * @param root
     * @return
     */
    public static int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 对于以root为根的树，计算抢劫根节点root与不抢劫根节点可获得最大金额
     *
     * @param root
     * @return
     */
    private static int[] robHelper(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }

}
