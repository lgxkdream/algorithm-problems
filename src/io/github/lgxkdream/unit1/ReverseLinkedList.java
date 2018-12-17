package io.github.lgxkdream.unit1;

import io.github.lgxkdream.common.Node;

/**
 * 
 * @title: ReverseLinkedList(单链表反转)
 * @description: 反转一个单链表。
				 示例:
		         输入: 1->2->3->4->5->NULL
				 输出: 5->4->3->2->1->NULL
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年10月31日 下午8:37:19
 */
public class ReverseLinkedList {

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
		
		// 调用反转方法
//		head = reverse1(head);
//		Node h1 = head;
		
		Node h1 = head;
		h1 = reverse1(h1);
		System.out.println("\n************11**************");
		// 打印反转后的结果
		while (null != h1) {
			System.out.print(h1.getData() + " ");
			h1 = h1.getNext();
		}
		
		// 调用反转方法
		head = reverse(head);
		System.out.println("\n************22**************");
		// 打印反转后的结果
		while (null != head) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
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
