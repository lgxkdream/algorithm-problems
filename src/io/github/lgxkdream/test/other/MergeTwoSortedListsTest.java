package io.github.lgxkdream.test.other;

import io.github.lgxkdream.common.ListNode;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title: MergeTwoSortedLists(合并两个有序链表)
 * @description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @since 2018年11月14日 下午6:04:03
 */
public class MergeTwoSortedListsTest {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(3);
        ListNode root2 = new ListNode(2);
        root2.next = new ListNode(6);
        ListNode merge = mergeTwoLists1(root, root2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = null;
        if (l1.val < l2.val) {
            result = l1;
            result.next = mergeTwoLists1(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists1(l1, l2.next);
        }
        return result;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeNode = null;
        if (l1.val < l2.val) {
            mergeNode = l1;
            l1 = l1.next;
        } else {
            mergeNode = l2;
            l2 = l2.next;
        }
        ListNode temp = mergeNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }
        return mergeNode;
    }

}