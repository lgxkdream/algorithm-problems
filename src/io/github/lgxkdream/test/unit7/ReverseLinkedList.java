package io.github.lgxkdream.test.unit7;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 链表相邻元素翻转
 * @description https://leetcode-cn.com/problems/reverse-linked-list/
 * @since 2020-05-16 10:49
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverse = reverseList(node1);
//        ListNode reverse = reverseList1(node1);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode node = reverseList(head.next.next);
        head.next.next = head;
        head.next = node;
        return newHead;
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead, cur = newHead.next, next;
        while (cur != null && cur.next != null) {
            next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return newHead.next;
    }

}
