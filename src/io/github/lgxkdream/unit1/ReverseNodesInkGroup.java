package io.github.lgxkdream.unit1;

import io.github.lgxkdream.common.ListNode;

/**
 * 
 * @title: ReverseNodesInkGroup(k个一组翻转链表)
 * @description: 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
				 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
				 示例 :
				 给定这个链表：1->2->3->4->5
				 当 k = 2 时，应当返回: 2->1->4->3->5
				 当 k = 3 时，应当返回: 3->2->1->4->5
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年12月17日 下午12:00:14
 */
public class ReverseNodesInkGroup {
	
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
		ListNode reverseKGroup = reverseKGroup(node1, 3);
		System.out.println("=================");
		while (reverseKGroup != null) {
			System.out.println(reverseKGroup.val);
			reverseKGroup = reverseKGroup.next;
		}
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode currentNode = head;
        int count = 0;
        while (currentNode != null && count != k) { // 每k个节点一组分隔
            currentNode = currentNode.next;
            count++;
        }
        if (count == k) {
            currentNode = reverseKGroup(currentNode, k); // 递归的解决子问题
            while (count-- > 0) { // 将头节点从链表中切掉，放在下一组链表的前端，切除k次，即可将链表翻转
                ListNode temp = head.next; // 保存该组链表的第二个节点
                head.next = currentNode; // head节点的下一位指向currentNode(第一次循环时是下一组链表的头节点，之后每截取一次就往前移)
                currentNode = head; // currentNode节点前移到head
                head = temp; // head节点重新指向该组的第一个节点，开始下次循环
            }
            head = currentNode; //最终，该段的所有节点将会截空，head应指向currentNode
        }
        return head;
    }

}
