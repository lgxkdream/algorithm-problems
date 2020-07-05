package io.github.lgxkdream.test.unit6;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 合并两个有序链表
 * @description https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @since 2020-05-01 11:03
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(4);
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);
        ListNode merge = mergeTwoLists(root, root2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result;
        if (l1.val <= l2.val) {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }

}
