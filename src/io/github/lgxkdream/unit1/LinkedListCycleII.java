package io.github.lgxkdream.unit1;

import io.github.lgxkdream.common.ListNode;

/**
 * 
 * @title: LinkedListCycleII(环形链表 II)
 * @description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年11月20日 下午12:17:48
 */
public class LinkedListCycleII {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		System.out.println(detectCycle(node1).val);
//		System.out.println(detectCycle1(node1).val);
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		// 少走一步，补上
		slow = slow.next;
		while (slow != head) {
			slow = slow.next;
			head = head.next;
		}
		return head;
	}

	public static ListNode detectCycle1(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode fp = head, sp = head;
		while (fp != null && fp.next != null) {
			sp = sp.next;
			fp = fp.next.next;
			// 判断是否成环
			if (fp == sp) {
				break;
			}
		}
		if (fp == null || fp.next == null) {
			return null;
		}
		while (sp != head) {
			sp = sp.next;
			head = head.next;
		}
		return head;
	}

}