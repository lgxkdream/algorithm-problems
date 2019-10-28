package io.github.lgxkdream.test;

import io.github.lgxkdream.common.Node;

public class ReverseLinkedListTest {

	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);

		// 打印反转前的链表
		Node h = head;
		while (null != h) {
			System.out.print(h.getData() + " ");
			h = h.getNext();
		}

		System.out.println();
		Node h1 = head;
		// 调用反转方法1
		h1 = reverse(h1);
		// 打印反转后的结果
		while (null != h1) {
			System.out.print(h1.getData() + " ");
			h1 = h1.getNext();
		}
	}

	private static Node reverse(Node head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		Node reHead = reverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return reHead;
	}
	
	private static Node reverse1(Node head) {
		if (head == null) {
			return head;
		}
		Node pre = head;
		Node cur = head.getNext();
		Node temp;
		while (cur != null) {
			temp = cur.getNext();
			cur.setNext(pre);
			pre = cur;
			cur = temp;
		}
		head.setNext(null);
		return pre;
	}

}
