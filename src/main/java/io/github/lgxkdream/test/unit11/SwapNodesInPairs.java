package io.github.lgxkdream.test.unit11;

import io.github.lgxkdream.common.CommonMethod;
import io.github.lgxkdream.common.ListNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 24. 两两交换链表中的节点
 * @description https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @since 2020-06-24 19:58
 */
public class SwapNodesInPairs {

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
        ListNode reverse = swapPairs(node1);
        CommonMethod.printlnLinkedList(reverse);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

}
