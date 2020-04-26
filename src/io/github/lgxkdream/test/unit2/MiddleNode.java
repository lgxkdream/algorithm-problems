package io.github.lgxkdream.test.unit2;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MiddleNode
 * @description https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @since 2020-03-23 09:18
 */
public class MiddleNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = middleNode1(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }
        int index = count / 2 + 1;
        while (head != null && --index > 0) {
            head = head.next;

        }
        return head;
    }

}
