package io.github.lgxkdream.unit12;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 92. 反转链表 II
 * @description https://leetcode.cn/problems/reverse-linked-list-ii/
 * @since 2022-05-13 12:44
 */
public class ReverseLinkedListII {

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

        // 打印反转前的链表
        ListNode h = node1;
        while (null != h) {
            System.out.print(h.val + " ");
            h = h.next;
        }

        ListNode h1 = node1;
        // 调用反转方法1
        h1 = reverseBetween(h1, 2, 4);
        System.out.println("************11**************");
        // 打印反转后的结果
        while (null != h1) {
            System.out.print(h1.val + " ");
            h1 = h1.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode temp;
        for (int i = left; i < right; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return root.next;
    }

}
