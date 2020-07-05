package io.github.lgxkdream.test.unit6;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 另一个树的子树
 * @description https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @since 2020-05-07 10:15
 */
public class SubtreeOfAnotherTree {

    /**
     * 思想：双重递归，第一重比较是不是子树，第二重比较是不是相等
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(3);
        TreeNode s2 = new TreeNode(4);
        TreeNode s3 = new TreeNode(5);
        TreeNode s4 = new TreeNode(1);
        TreeNode s5 = new TreeNode(2);
        s1.left = s2;
        s1.right = s3;
        s2.left = s4;
        s2.right = s5;

        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        System.out.println(isSubtree(s1, t1));
    }

    /**
     * 比较是不是子树
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 比较是不是相同的树
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
