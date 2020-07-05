package io.github.lgxkdream.test.unit7;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 二叉树的最近公共祖先
 * @description https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @since 2020-05-10 09:53
 */
public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode r0 = new TreeNode(0);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        r3.left = r5;
        r3.right = r1;
        r5.left = r6;
        r5.right = r2;
        r2.left = r7;
        r2.right = r4;
        r1.left = r0;
        r1.right = r8;

        TreeNode node = lowestCommonAncestor(r3, r5, r1); // 3
        System.out.println(node.val);
        node = lowestCommonAncestor(r3, r5, r4); // 5
        System.out.println(node.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉树为空，肯定不存在两节点
        if (root == null) {
            return null;
        }
        // 二叉树当前节点等于查找的两节点之一时，如果当前节点root是二叉树根节点，则直接就是两节点的公共祖先，如果不是则返回已找到p或q其中一节点
        if (root == p || root == q) {
            return root;
        }
        // 向当前节点的左子树查找
        TreeNode leftFind = lowestCommonAncestor(root.left, p, q);
        // 向当前节点的右子树查找
        TreeNode rightFind = lowestCommonAncestor(root.right, p, q);
        // 如果左右子树分别找到，则当前节点为公共祖先
        if (leftFind != null && rightFind != null) {
            return root;
        }
        // 如果只有左子树找到，则左子树找到的为公共祖先（没找到的另一个节点在该子树里面）
        if (leftFind != null) {
            return leftFind;
        }
        // 如果只有右子树找到，则右子树找到的为公共祖先（没找到的另一个节点在该子树里面）
        if (rightFind != null) {
            return rightFind;
        }
        // 左右子树都没找到，不存在公共祖先
        return null;
    }

}
