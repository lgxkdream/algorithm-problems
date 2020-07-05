package io.github.lgxkdream.test.unit8;

import io.github.lgxkdream.common.TreeNode;
import io.github.lgxkdream.test.unit1.Test0314;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 从前序与中序遍历序列构造二叉树
 * @description https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @since 2020-05-22 10:15
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        // 前序遍历
        int[] preorder = {3, 9, 20, 15, 7};
        // 中序遍历
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(Test0314.preorderTraversal(treeNode));
        System.out.println(Test0314.inorderTraversal1(treeNode));
    }

    /**
     * 递归思想，不断找到子树的根节点
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, inorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
    }

}
