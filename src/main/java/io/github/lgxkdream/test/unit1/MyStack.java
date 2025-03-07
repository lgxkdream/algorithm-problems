package io.github.lgxkdream.test.unit1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MyStack
 * @description
 * @since 2020-03-17 16:42
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(6);
        myStack.push(7);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    private Queue<Integer> a;
    private Queue<Integer> b;

    /** Initialize your data structure here. */
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        a.offer(x);
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
        Queue<Integer> temp = a;
        a = b;
        b = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return b.poll();
    }

    /** Get the top element. */
    public int top() {
        return b.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return b.isEmpty();
    }

}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
