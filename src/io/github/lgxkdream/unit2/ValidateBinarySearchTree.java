package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 验证二叉搜索树
 * @description https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @since 2020-05-05 09:18
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;
        System.out.println(isValidBST(p1)); // true

        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(6);
        r1.left = r2;
        r1.right = r3;
        r3.left = r4;
        r3.right = r5;
        System.out.println(isValidBST(r1)); // false

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n3.left = n1;
        n3.right = n5;
        n1.left = n0;
        n1.right = n2;
        n2.right = n3;
        n5.left = n4;
        n5.right = n6;
        System.out.println(isValidBST(n3)); // false
    }

    /**
     * 保存中序遍历的上一个值
     */
    private static Integer preVal = null;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            // 如果左子树不是，直接返回
            return false;
        }
        if (preVal != null && preVal >= root.val) {
            // 如果上一个值大于当前遍历的值，则返回false
            return false;
        }
        // 更新上一个值
        preVal = root.val;
        return isValidBST(root.right);
    }

}
