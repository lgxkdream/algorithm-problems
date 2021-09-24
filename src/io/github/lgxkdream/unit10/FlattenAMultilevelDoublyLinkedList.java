package io.github.lgxkdream.unit10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 430. 扁平化多级双向链表
 * @description https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * @since 2021-09-24 21:02
 */
public class FlattenAMultilevelDoublyLinkedList {

    public static void main(String[] args) {

    }

    public static Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Deque<Node> stack = new ArrayDeque<>();
        while (true) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            if (cur.next != null) {
                cur = cur.next;
            } else if (!stack.isEmpty()) {
                Node pop = stack.pop();
                cur.next = pop;
                pop.prev = cur;
                cur.child = null;
            } else {
                return head;
            }
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
