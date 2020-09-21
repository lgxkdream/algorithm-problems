package io.github.lgxkdream.common;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 通用方法
 * @description
 * @since 2020-06-24 20:08
 */
public class CommonMethod {

    /**
     * 链表打印
     */
    public static void printlnLinkedList(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    /**
     * 二叉树打印
     */
    // BinaryTreeLevelOrderTraversal.levelOrder1

}
