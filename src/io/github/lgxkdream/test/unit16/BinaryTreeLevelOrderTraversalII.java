package io.github.lgxkdream.test.unit16;

import io.github.lgxkdream.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 107. 二叉树的层次遍历 II
 * @description https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @since 2020-09-06 21:08
 */
public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(20);
        TreeNode p4 = new TreeNode(15);
        TreeNode p5 = new TreeNode(7);
        p1.left = p2;
        p1.right = p3;
        p3.left = p4;
        p3.right = p5;
        System.out.println(levelOrderBottom(p1));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

}
