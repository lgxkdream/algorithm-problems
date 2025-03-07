package io.github.lgxkdream.test.unit11;

import io.github.lgxkdream.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 297. 二叉树的序列化与反序列化
 * @description
 * @since 2020-06-16 12:10
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        // p1.left = p2;
        // p2.left = p4;
        // p3.left = p4;
        // p3.right = p5;

        p1.right = p3;

        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);
        // p4.left = p6;
        // p4.right = p7;

        String serialize = serialize(p1);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(serialize(deserialize));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<Integer> varList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                varList.add(null);
            } else {
                varList.add(poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        return varList.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        TreeNode root = getNode(split[0]);
        TreeNode parent = root;
        Queue<TreeNode> parents = new LinkedList<>();
        boolean isLeft = true;
        for (int i = 1; i < split.length; i++) {
            TreeNode node = getNode(split[i]);
            if (isLeft) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            if (node != null) {
                parents.offer(node);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = parents.poll();
            }
        }
        return root;
    }

    private static TreeNode getNode(String val) {
        if ("null".equals(val)) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(val));
        }
    }

    // Encodes a tree to a single string.
    public static String serialize1(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                preorderList.add(root.val);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                inorderList.add(pop.val);
                root = pop.right;
            }
        }
        return preorderList.stream().map(String::valueOf).collect(Collectors.joining(",")) + "#" +
                inorderList.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize1(String data) {
        if (data == null || data.length() <= 1) {
            return null;
        }
        String[] split = data.split("#");
        return buildTree(split[0].split(","), split[1].split(","));
    }

    private static TreeNode buildTree(String[] preorder, String[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(preorder[0]));
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0].equals(inorder[i])) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
    }

}
