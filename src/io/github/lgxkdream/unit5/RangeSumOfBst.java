package io.github.lgxkdream.unit5;

import io.github.lgxkdream.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 938. 二叉搜索树的范围和
 * @description https://leetcode-cn.com/problems/range-sum-of-bst/
 * @since 2021-04-27 20:32
 */
public class RangeSumOfBst {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(5);
        TreeNode p3 = new TreeNode(7);
        TreeNode p4 = new TreeNode(10);
        TreeNode p5 = new TreeNode(15);
        TreeNode p6 = new TreeNode(18);
        p4.left = p2;
        p4.right = p5;
        p2.left = p1;
        p2.right = p3;
        p5.right = p6;
        /**
         * 输出：32
         */
        System.out.println(rangeSumBST(p4, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                TreeNode pop = stack.pop();
                if (pop.val > high) {
                    break;
                } else if (pop.val >= low) {
                    sum += pop.val;
                }
                node = pop.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
        return sum;
    }

}
