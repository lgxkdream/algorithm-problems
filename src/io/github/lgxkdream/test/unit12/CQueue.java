package io.github.lgxkdream.test.unit12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 剑指 Offer 09. 用两个栈实现队列
 * @description https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @since 2020-06-30 10:01
 */
public class CQueue {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public static void main(String[] args) {
        /**
         * 输出：[null,null,3,-1]
         */
        CQueue queue1 = new CQueue();
        queue1.appendTail(3);
        System.out.println(queue1.deleteHead());
        System.out.println(queue1.deleteHead());

        /**
         * 输出：[null,-1,null,null,5,2]
         */
        CQueue queue2 = new CQueue();
        queue2.deleteHead();
        queue2.appendTail(5);
        queue2.appendTail(2);
        System.out.println(queue2.deleteHead());
        System.out.println(queue2.deleteHead());
    }

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

}
