package io.github.lgxkdream.test.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test10
 * @description
 * @since 2020-02-20 15:06
 */
public class Test10 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);

        node1.left = node21;
        node1.right = node22;
        node21.left = node31;
        node21.right = node41;
        node22.left = node42;
        node22.right = node32;
        System.out.println(isSymmetric1(node1));
    }

    public static boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
