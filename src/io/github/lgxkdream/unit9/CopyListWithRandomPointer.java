package io.github.lgxkdream.unit9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 138. 复制带随机指针的链表
 * @description https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @since 2021-07-22 22:54
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    static Map<Node, Node> map = new HashMap<>();

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        if (!map.containsKey(head)) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            newNode.random = copyRandomList(head.random);
            newNode.next = copyRandomList(head.next);
        }
        return map.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
