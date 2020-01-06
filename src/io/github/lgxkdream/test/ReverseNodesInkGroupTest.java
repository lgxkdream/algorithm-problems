package io.github.lgxkdream.test;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title: ReverseNodesInkGroupTest
 * @description:
 * @Copyright: Copyright (c) 2019
 * @Company: lgxkdream.github.io
 * @since 2019-11-21 20:21
 */
public class ReverseNodesInkGroupTest {

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
        ListNode reverseKGroup = reverseKGroup(node1, 2);
        System.out.println("=================");
        while (reverseKGroup != null) {
            System.out.println(reverseKGroup.val);
            reverseKGroup = reverseKGroup.next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null && count != k) {
            currentNode = currentNode.next;
            count ++;
        }
        if (count == k) {
            currentNode = reverseKGroup(currentNode, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = currentNode;
                currentNode = head;
                head = temp;
            }
            head = currentNode;
        }
        return head;
    }

}
