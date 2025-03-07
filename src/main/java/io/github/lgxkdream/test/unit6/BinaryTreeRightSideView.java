package io.github.lgxkdream.test.unit6;

import io.github.lgxkdream.common.TreeNode;

import java.util.*;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 二叉树的右视图
 * @description https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @since 2020-04-22 10:14
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        p1.left = p2;
        p1.right = p3;
        p2.right = p5;
        p3.left = p6;
        System.out.println(rightSideView2(p1)); // [1, 3, 4]
    }

    /**
     * TODO 代码有问题，待修复
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int depth = 0;
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                TreeNode pop = stack.pop();
                root = pop.left;
            } else {
                if (depth == result.size()) {
                    result.add(root.val);
                }
                depth++;
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    public static List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNum = 1, nextNum = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                if (poll.left != null) {
                    queue.offer(poll.left);
                    nextNum++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    nextNum++;
                }
            }
            curNum--;
            if (curNum == 0) {
                result.add(poll.val);
                curNum = nextNum;
                nextNum = 0;
            }
        }
        return result;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (size == 0) {
                    result.add(poll.val);
                }
            }
        }
        return result;
    }

}
