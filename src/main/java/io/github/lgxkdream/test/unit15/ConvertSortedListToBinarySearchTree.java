package io.github.lgxkdream.test.unit15;

import io.github.lgxkdream.common.ListNode;
import io.github.lgxkdream.common.TreeNode;
import io.github.lgxkdream.unit2.BinaryTreeLevelOrderTraversal;

import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 109. 有序链表转换二叉搜索树
 * @description https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @since 2020-08-18 10:03
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        /**
         * 给定的有序链表： [-10, -3, 0, 5, 9],
         *
         * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
         *
         *       0
         *      / \
         *    -3   9
         *    /   /
         *  -10  5
         *
         */
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        TreeNode treeNode = sortedListToBST(node1);
        List<List<Integer>> lists = BinaryTreeLevelOrderTraversal.levelOrder1(treeNode);
        System.out.println(lists);
    }

    /**
     * 快慢指针思想
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 找中间节点，即slow
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 截断成两段
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        root.left = sortedListToBST(head);
        return root;
    }

}
