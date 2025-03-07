package io.github.lgxkdream.unit6;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 993. 二叉树的堂兄弟节点
 * @description https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * @since 5/17/21 11:02 PM
 */
public class CousinsInBinaryTree {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        /**
         * 输出：false
         */
        System.out.println(new CousinsInBinaryTree().isCousins(p1, 4, 3));
        p1 = new TreeNode(1);
        p2 = new TreeNode(2);
        p3 = new TreeNode(3);
        p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        p1.left = p2;
        p1.right = p3;
        p2.right = p4;
        p3.right = p5;
        /**
         * 输出：true
         */
        System.out.println(new CousinsInBinaryTree().isCousins(p1, 5, 4));
        p1 = new TreeNode(1);
        p2 = new TreeNode(2);
        p3 = new TreeNode(3);
        p4 = new TreeNode(4);
        p1.left = p2;
        p1.right = p3;
        p2.right = p4;
        /**
         * 输出：false
         */
        System.out.println(new CousinsInBinaryTree().isCousins(p1, 2, 3));
    }

    int x;
    int xDepth;
    TreeNode xParent;
    boolean xFound;
    int y;
    int yDepth;
    TreeNode yParent;
    boolean yFound;

    /**
     * dfs
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, null, 0);
        return xParent != yParent && xDepth == yDepth;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth) {
        if (root == null) {
            return;
        }
        if (xFound && yFound) {
            return;
        }
        if (root.val == x) {
            xParent = parent;
            xDepth = depth;
            xFound = true;
        }
        if (root.val == y) {
            yParent = parent;
            yDepth = depth;
            yFound = true;
        }
        dfs(root.left, root, depth + 1);
        dfs(root.right, root, depth + 1);
    }

}
