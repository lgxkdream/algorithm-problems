package io.github.lgxkdream.unit1;

import java.util.Stack;

import io.github.lgxkdream.common.ListNode;

/**
 * 
 * @title: RemoveNthNodeFromEndOfList(删除链表的倒数第N个节点)
 * @description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
				 示例：
				 给定一个链表: 1->2->3->4->5, 和 n = 2.
				 当删除了倒数第二个节点后，链表变为 1->2->3->5.
				 说明：
				 给定的 n 保证是有效的。
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年12月14日 下午5:19:15
 */
public class RemoveNthNodeFromEndOfList {

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
		ListNode newRoot = removeNthFromEnd1(node1, 1);
//		ListNode newRoot = removeNthFromEnd2(node1, 3);
		System.out.println("=================");
		while (newRoot != null) {
			System.out.println(newRoot.val);
			newRoot = newRoot.next;
		}
	}

	// 方法一：双指针
	private static ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		for (int k = 0; k < n; k++) { // 让前一个指针先走n步
			first = first.next;
		}
		if (first == null) {
			return head.next; // 链表的长度刚刚好等于n，头结点为要删除的节点
		}
		while (first.next != null) { // 两个指针同时向后走，直到前一个指针走到链表最后一个节点的next
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next; // 将要删除节点的前一个节点指向要删除节点的后一个节点
		return head;
	}

	// 方法二：借助栈
	private static ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode temp = head;
		Stack<ListNode> stack = new Stack<>();
		while (temp != null) { // 先用栈存储整个链表
			stack.push(temp);
			temp = temp.next;
		}
		if (stack.size() == n) { // 如果栈的大小刚刚好等于n，头结点为要删除的节点
			return head.next;
		}
		for (int k = 0; k <= n; k++) { // 逐个弹栈，相当于链表从后向前遍历
			ListNode peek = stack.pop();
			if (k == n) { // 将要删除节点的前一个节点指向要删除节点的后一个节点
				peek.next = temp;
			}
			if (k == n - 2) { // 保存要删除的节点的后一个节点
				temp = peek;
			}
		}
		return head;
	}
	
}
