package io.github.lgxkdream.test.unit17;

import io.github.lgxkdream.common.TreeNode;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 94. 二叉树的中序遍历
 * @description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @since 2020-09-14 09:54
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        root.right = p1;
        p1.left = p2;
        /**
         * 输出: [1,3,2]
         */
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                node = pop.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }

}
