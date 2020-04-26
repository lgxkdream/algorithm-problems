package io.github.lgxkdream.test.unit2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title LRUCache
 * @description
 * @since 2020-03-19 14:28
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    private class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        ListNode listNode = new ListNode(key, value);
        map.put(key, listNode);
        moveToTail(listNode);
        if (map.size() > capacity) {
            ListNode next = head.next;
            map.remove(next.key);
            next.next.pre = head;
            head.next = head.next.next;
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode listNode = map.get(key);
        listNode.pre.next = listNode.next;
        listNode.next.pre = listNode.pre;
        moveToTail(listNode);
        return listNode.value;
    }

    private void moveToTail(ListNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

}
