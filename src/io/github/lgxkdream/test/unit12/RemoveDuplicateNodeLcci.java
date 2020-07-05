package io.github.lgxkdream.test.unit12;

import io.github.lgxkdream.common.CommonMethod;
import io.github.lgxkdream.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 02.01. 移除重复节点
 * @description https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @since 2020-06-26 07:50
 */
public class RemoveDuplicateNodeLcci {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(3);
        ListNode node15 = new ListNode(2);
        ListNode node16 = new ListNode(1);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        /**
         * 输出：[1, 2, 3]
         */
        ListNode root1 = removeDuplicateNodes(node11);
        CommonMethod.printlnLinkedList(root1);
        System.out.println("============");

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        ListNode node23 = new ListNode(1);
        ListNode node24 = new ListNode(1);
        ListNode node25 = new ListNode(2);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        /**
         * 输出：[1, 2]
         */
        ListNode root2 = removeDuplicateNodes(node21);
        CommonMethod.printlnLinkedList(root2);
    }


    /**
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> existNodes = new HashSet<>();
        existNodes.add(head.val);
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            while (cur != null && existNodes.contains(cur.val)) {
                cur = cur.next;
            }
            if (cur == null) {
                pre.next = null;
                break;
            }
            existNodes.add(cur.val);
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> existNodes = new HashSet<>();
        existNodes.add(head.val);
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (existNodes.add(cur.val)) {
                pre = cur;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre.next = cur;
            }
        }
        return head;
    }

    /**
     * LeetCode解法
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

}
