package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.ListNode;

/**
 * 
 * @title: DeleteNodeInALinkedList(删除链表中的节点)
 * @description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
				 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
				     4 -> 5 -> 1 -> 9
				 示例 1:
				 输入: head = [4,5,1,9], node = 5
				 输出: [4,1,9]
				 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
				 示例 2:
				 输入: head = [4,5,1,9], node = 1
				 输出: [4,5,9]
				 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
				 说明:
				 链表至少包含两个节点。
				 链表中所有节点的值都是唯一的。
				 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
				 不要从你的函数中返回任何结果。
 * @Copyright: Copyright (c) 2018
 * @company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年12月27日 上午11:17:29
 */
public class DeleteNodeInALinkedList {
	
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
		deleteNode(node3);
		System.out.println("=================");
		while (node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}
	
	public static void deleteNode(ListNode node) {
        node.val = node.next.val; // 将想要删除的节点的值替换为它后面节点中的值
        node.next = node.next.next; // 删除它之后的节点
    }

}
