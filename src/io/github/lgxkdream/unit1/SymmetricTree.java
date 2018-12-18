package io.github.lgxkdream.unit1;

import java.util.LinkedList;
import java.util.Queue;

import io.github.lgxkdream.common.TreeNode;

/**
 * 
 * @title: SymmetricTree(对称二叉树)
 * @description: 给定一个二叉树，检查它是否是镜像对称的。
				 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
				     1
				    / \
				   2   2
			   	  / \ / \
				 3  4 4  3
				 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
				    1
				   / \
				  2   2
				   \   \
				   3    3
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年11月12日 下午8:48:39
 */
public class SymmetricTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		System.out.println(isSymmetric1(root));
		System.out.println(isSymmetric2(root));
	}

	private static boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			if (node1 == null && node2 == null) {
				continue;
			}
			if (node1 == null || node2 == null) {
				return false;
			}
			if (node1.var != node2.var) {
				return false;
			}
			queue.offer(node1.left);
			queue.offer(node2.right);
			queue.offer(node1.right);
			queue.offer(node2.left);
		}
		return true;
	}

	private static boolean isSymmetric1(TreeNode root) {
		return isMirror(root, root);
	}

	private static boolean isMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		return (root1.var == root2.var) && isMirror(root1.right, root2.left) && isMirror(root1.left, root2.right);
	}
	
}