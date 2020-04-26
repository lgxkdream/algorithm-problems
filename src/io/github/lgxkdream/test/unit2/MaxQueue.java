package io.github.lgxkdream.test.unit2;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MaxQueue
 * @description
 * @since 2020-03-21 20:25
 */
public class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        Integer maxValue = deque.peekFirst();
        return maxValue == null ? -1 : maxValue;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        Integer poll = queue.poll();
        if (poll == null) {
            return -1;
        }
        int peek = deque.peek();
        if (poll == peek) {
            deque.pollFirst();
        }
        return poll;
    }

    public static void main(String[] args) {
        // ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
        // [[],[1],[2],[],[],[]]
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
    }

}
