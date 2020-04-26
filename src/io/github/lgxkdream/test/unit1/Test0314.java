package io.github.lgxkdream.test.unit1;

import io.github.lgxkdream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test0314
 * @description
 * @since 2020-03-14 21:22
 */
public class Test0314 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        root.right = p1;
        p1.left = p2;
        // List<Integer> result = inorderTraversal(root);
        List<Integer> result = preorderTraversal(root);
        result.forEach(System.out::println);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(result, root);
        return result;
    }

    public static void inorderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(result, root.left);
        result.add(root.val);
        inorderTraversal(result, root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                node = pop.right;
            }
        }
        return result;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                result.add(node.val);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                node = pop.right;
            }
        }
        return result;
    }

}
