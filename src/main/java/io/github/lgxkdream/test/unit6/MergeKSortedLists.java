package io.github.lgxkdream.test.unit6;

import io.github.lgxkdream.common.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 合并K个排序链表
 * @description https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @since 2020-04-26 10:04
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        /**
         * 1->4->5,
         * 1->3->4,
         * 2->6
         */
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        node31.next = node32;

        ListNode[] lists = {node11, node21, node31};
        ListNode root = mergeKLists(lists);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        Arrays.asList(lists).stream().filter(Objects::nonNull).forEach(node -> queue.offer(node));
        ListNode result = null;
        ListNode temp = null;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            ListNode next = poll.next;
            if (next != null) {
                queue.offer(next);
            }
            if (result == null) {
                result = poll;
                temp = result;
            } else {
                temp.next = poll;
                temp = temp.next;
            }
        }
        return result;
    }

}
