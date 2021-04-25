package io.github.lgxkdream.unit5;

import io.github.lgxkdream.common.TreeNode;
import io.github.lgxkdream.unit2.BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 897. 递增顺序搜索树
 * @description https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @since 4/25/21 12:36 AM
 */
public class increasingOrderSearchTree {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(8);
        TreeNode p9 = new TreeNode(9);
        p5.left = p3;
        p5.right = p6;
        p3.left = p2;
        p3.right = p4;
        p2.left = p1;
        p6.right = p8;
        p8.left = p7;
        p8.right = p9;

        /**
         * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
         * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
         */
        TreeNode res = increasingBST(p5);
        List<List<Integer>> lists = BinaryTreeLevelOrderTraversal.levelOrder1(res);
        System.out.println(lists);
    }

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode res = null, temp = null;
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                TreeNode pop = stack.pop();
                if (temp == null) {
                    res = pop;
                    temp = res;
                } else {
                    temp.left = null;
                    temp.right = pop;
                    temp = temp.right;
                }
                node = pop.right;
            } else {
                stack.push(node);
                node = node.left;
            }
        }
        temp.left = null;
        temp.right = null;
        return res;
    }

}
