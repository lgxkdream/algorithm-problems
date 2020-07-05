package io.github.lgxkdream.test.unit11;

import io.github.lgxkdream.common.TreeNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1028. 从先序遍历还原二叉树
 * @description https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 * @since 2020-06-18 10:09
 */
public class RecoverATreeFromPreorderTraversal {

    public static void main(String[] args) {
        /**
         * 输出：[1,2,5,3,4,6,7]
         */
        TreeNode treeNode = recoverFromPreorder("1-2--3--4-5--6--7");
        SerializeAndDeserializeBinaryTree.serialize(treeNode);
        /**
         * 输出：[1,2,5,3,null,6,null,4,null,7]
         */
        TreeNode treeNode1 = recoverFromPreorder("1-2--3---4-5--6---7");
        SerializeAndDeserializeBinaryTree.serialize(treeNode1);
        /**
         * 输出：[1,401,null,349,88,90]
         */
        TreeNode treeNode2 = recoverFromPreorder("1-401--349---90--88");
        SerializeAndDeserializeBinaryTree.serialize(treeNode2);
    }

    public static TreeNode recoverFromPreorder(String S) {

        return null;
    }

}
