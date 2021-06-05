package io.github.lgxkdream.unit7;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 203. 移除链表元素
 * @description https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @since 2021-06-05 21:30
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        /**
         * 输出：[1,2,3,4,5]
         */
        ListNode listNode = removeElements(node1, 6);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        System.out.println("=============");

        node1 = new ListNode(7);
        node2 = new ListNode(7);
        node3 = new ListNode(7);
        node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        /**
         * 输出：[]
         */
        listNode = removeElements(node1, 7);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode myHead = new ListNode(-1);
        myHead.next = head;
        ListNode pre = myHead, cur = myHead.next;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return myHead.next;
    }

}
