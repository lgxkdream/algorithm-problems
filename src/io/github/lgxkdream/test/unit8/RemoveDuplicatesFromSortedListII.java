package io.github.lgxkdream.test.unit8;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 删除排序链表中的重复元素 II
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @since 2020-05-23 18:23
 */
public class RemoveDuplicatesFromSortedListII {

    // TODO 隔一段时间重新练习
    public static void main(String[] args) {
        // 1->2->3->3->4->4->5
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node31 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node41 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node31;
        node31.next = node4;
        node4.next = node41;
        node41.next = node5;

        // 1->1->1->2->3
        // ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(1);
        // ListNode node3 = new ListNode(1);
        // ListNode node31 = new ListNode(2);
        // ListNode node4 = new ListNode(3);
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node31;
        // node31.next = node4;
        ListNode listNode = deleteDuplicates(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 双指针思想
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        ListNode left = virtualNode;
        ListNode right = virtualNode.next;
        while (right != null && right.next != null) {
            if (left.next.val != right.next.val) {
                left = left.next;
                right = right.next;
            } else {
                while (right != null && right.next != null && left.next.val == right.next.val) {
                    right = right.next;
                }
                right = right.next;
                left.next = right;
            }
        }
        return virtualNode.next;
    }

}
