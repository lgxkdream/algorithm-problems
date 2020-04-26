package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @title BinaryTreeLevelOrderTraversal(二叉树的层次遍历) https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @description 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *              例如:
 *              给定二叉树: [3,9,20,null,null,15,7],
 *                  3
 *                 / \
 *                9  20
 *                  /  \
 *                 15   7
 *              返回其层次遍历结果：
 *              [
 *                [3],
 *                [9,20],
 *                [15,7]
 *              ]
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2020-03-10 21:38
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p1 = new TreeNode(9);
        TreeNode p2 = new TreeNode(20);
        TreeNode p3 = new TreeNode(15);
        TreeNode p4 = new TreeNode(7);
        root.left = p1;
        root.right = p2;
        p2.left = p3;
        p2.right = p4;
        List<List<Integer>> lists = levelOrder1(root);
        lists.forEach(System.out::println);
        /**
         * [3]
         * [9, 20]
         * [15, 7]
         */
    }

    /**
     * 递归 深度优先搜索 前序遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        return result;
    }

    /**
     * 递归 实际是深度优先搜索前序遍历
     *
     * @param result 结果
     * @param root   遍历的节点
     * @param level  第几层
     */
    private static void levelOrder(List<List<Integer>> result, TreeNode root, int level) {
        // 开始当前层遍历
        if (root == null) {
            return;
        }
        // 初始化当前层
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        // 填充当前层
        result.get(level).add(root.val);
        // 处理下一级的子节点
        levelOrder(result, root.left, level + 1);
        levelOrder(result, root.right, level + 1);
    }

    /**
     * 迭代 宽度优先搜索
     *
     * @param root 根节点
     * @return
     */
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        while (!queue.isEmpty()) {
            // 开始当前层遍历
            result.add(new ArrayList<>());
            // 获取当前层的元素数
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // 填充当前层
                result.get(level).add(node.val);
                // 在下一层的队列中添加当层的子节点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 层数+1 去下一层
            level++;
        }
        return result;
    }

}
