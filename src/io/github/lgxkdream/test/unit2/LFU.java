package io.github.lgxkdream.test.unit2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test2
 * @description
 * @since 2020-04-01 15:29
 */
public class LFU {

    public static void main(String[] args) {
        LFU cache = new LFU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4
    }

    private class Node {
        int key;
        int value;
        int freq;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private Map<Integer, Node> cache;
    private Map<Integer, LinkedHashSet<Node>> freqMap;
    private int size;
    private int capacity;
    private int minFreq;

    public LFU(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.freqMap = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqIncr(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity < 1) {
            return;
        }
        Node node = cache.get(key);
        if (node == null) {
            if (size == capacity) {
                Node dead = removeNode();
                cache.remove(dead.key);
                size--;
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            size++;
        } else {
            node.value = value; // 更新值
            freqIncr(node);
        }
    }

    private void addNode(Node node) {
        LinkedHashSet<Node> nodes = freqMap.get(1);
        if (nodes == null) {
            nodes = new LinkedHashSet<>();
            freqMap.put(1, nodes);
        }
        nodes.add(node);
        minFreq = 1;
    }

    private Node removeNode() {
        LinkedHashSet<Node> nodes = freqMap.get(minFreq);
        Node dead = nodes.iterator().next();
        nodes.remove(dead);
        return dead;
    }

    private void freqIncr(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        node.freq = freq + 1;
        if (minFreq == freq && set.isEmpty()) {
            minFreq = node.freq;
        }
        LinkedHashSet<Node> newSet = freqMap.get(node.freq);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(node.freq, newSet);
        }
        newSet.add(node);
    }

}
