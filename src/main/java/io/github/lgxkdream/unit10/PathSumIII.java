package io.github.lgxkdream.unit10;

import io.github.lgxkdream.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 437. 路径总和 III
 * @description https://leetcode-cn.com/problems/path-sum-iii/
 * @since 2021-09-28 21:08
 */
public class PathSumIII {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(3, n1, n2);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2, null, n4);
        TreeNode n6 = new TreeNode(5, n3, n5);
        TreeNode n7 = new TreeNode(11);
        TreeNode n8 = new TreeNode(-3, null, n7);
        TreeNode n9 = new TreeNode(10, n6, n8);
        /**
         * 输出：3
         */
        System.out.println(pathSum(n9, 8));
    }

    /**
     * 前缀和
     */
    public static int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return getSum(root, targetSum, prefix, 0);
    }

    private static int getSum(TreeNode root, int targetSum, Map<Integer, Integer> prefix, int cur) {
        if (root == null) {
            return 0;
        }
        cur += root.val;
        int res = 0;
        res += prefix.getOrDefault(cur - targetSum, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        res += getSum(root.left, targetSum, prefix, cur);
        res += getSum(root.right, targetSum, prefix, cur);
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
        return res;
    }

}
