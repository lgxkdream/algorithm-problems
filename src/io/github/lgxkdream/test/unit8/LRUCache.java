package io.github.lgxkdream.test.unit8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-25 10:13
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    private Map<Integer, ListNode> map;
    private int capacity;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (this.get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        ListNode addNode = new ListNode(key, value);
        map.put(key, addNode);
        moveToTail(addNode);
        if (map.size() > capacity) {
            ListNode deleteNode = head.next;
            head.next = deleteNode.next;
            deleteNode.next.pre = head;
            map.remove(deleteNode.key);
        }
    }

    private void moveToTail(ListNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
    }

    private class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
