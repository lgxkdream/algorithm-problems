package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.TreeNode;

/**
 * 
 * @title: SameTree(相同的树)
 * @description: 给定两个二叉树，编写一个函数来检验它们是否相同。
				 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
				 示例 1:
				 输入:       1         1
				           / \       / \
				          2   3     2   3
				 
				         [1,2,3],   [1,2,3]
				 输出: true
				 示例 2:
				 输入:      1          1
				           /           \
				          2             2
				 
				         [1,2],     [1,null,2]
				 输出: false
				 示例 3:
				 输入:       1         1
				           / \       / \
				          2   1     1   2
				 
				         [1,2,1],   [1,1,2]
				 输出: false
 * @Copyright: Copyright (c) 2018
 * @company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年12月29日 下午2:22:09
 */
public class SameTree {
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode();
		root1.val = 1;
		root1.left = new TreeNode();
		TreeNode root2 = new TreeNode();
		root2.val = 1;
		root2.left = new TreeNode();
		System.out.println(isSameTree(root1, root2));
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) { // 都不为空
            if (p.val != q.val) { // 值不一样，不相等
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // 递归遍历继续判断
            }
        } else {
            if (p == null && q == null) { // 都为空，相等
                return true;
            } else { // 一个为空，一个不为空，不相等
                return false;
            }
        }
    }

}
