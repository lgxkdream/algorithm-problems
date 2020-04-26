package io.github.lgxkdream.test.unit5;

import io.github.lgxkdream.common.ListNode;

import java.util.Stack;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title AddTwoNumbers
 * @description https://leetcode-cn.com/problems/add-two-numbers-ii/
 * @since 2020-04-14 09:55
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;

        ListNode listNode = addTwoNumbers(node1, node5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || sum != 0) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            ListNode cur = new ListNode(sum % 10);
            cur.next = head;
            head = cur;
            sum = sum / 10;
        }
        return head;
    }

}
