package io.github.lgxkdream.test.unit1;

import java.util.Stack;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MyQueue
 * @description
 * @since 2020-03-17 17:15
 */
public class MyQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!output.isEmpty()) {
            input.push(output.pop());
        }
        output.push(x);
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty();
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
