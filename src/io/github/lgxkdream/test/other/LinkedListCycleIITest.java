package io.github.lgxkdream.test.other;

import io.github.lgxkdream.common.ListNode;

public class LinkedListCycleIITest {
	
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

	private static ListNode detectCycle(ListNode node1) {
		return null;
	}
	
	private static ListNode detectCycle1(ListNode node1) {
		return null;
	}

}
