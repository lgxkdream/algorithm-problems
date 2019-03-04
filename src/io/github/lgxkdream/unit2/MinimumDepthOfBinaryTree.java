package io.github.lgxkdream.unit2;

import io.github.lgxkdream.common.TreeNode;

/**
 * 
 * @title: MinimumDepthOfBinaryTree(二叉树的最小深度)
 * @description: 给定一个二叉树，找出其最小深度。
                 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
                 说明: 叶子节点是指没有子节点的节点。
                 示例:
                 给定二叉树 [3,9,20,null,null,15,7],
                     3
                    / \
                   9  20
                     /  \
                    15   7
                 返回它的最小深度  2.
 * @Copyright: Copyright (c) 2019
 * @company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2019年3月4日 下午3:41:12
 */
public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 3;
		TreeNode left1 = new TreeNode();
		left1.val = 9;
		TreeNode righ1 = new TreeNode();
		righ1.val = 20;
		TreeNode left2 = new TreeNode();
		left2.val = 15;
		TreeNode right2 = new TreeNode();
		right2.val = 7;
		root.left = left1;
		root.right = righ1;
		righ1.left = left2;
		righ1.right = right2;
		System.out.println(minDepth(root)); // 结果 2
		System.out.println(minDepth1(root)); // 结果 2
	}

	private static int minDepth(TreeNode root) {
		if (root == null) {
			return 0; // 第一种情况
		}
		if (root.left == null && root.right == null) {
			return 1; // 第二种情况 左子和右子都为空，即为叶子节点
		}
		if (root.left != null && root.right != null) {
			int l = minDepth(root.left);
			int r = minDepth(root.right);
			return (l < r ? l : r) + 1; // 第三种情况 取左子和右子遍历后的最小深度
		}
		if (root.left != null) {
			return minDepth(root.left) + 1; // 第四种情况 左子不为空，继续遍历左子
		} else {
			return minDepth(root.right) + 1; // 第五种情况 或者右子不为空，继续遍历右子
		}
	}

	// 另一种解法
	private static int minDepth1(TreeNode root) {
		if (root == null) {
			return 0; // 第一种情况
		}
		int l = minDepth(root.left);
		int r = minDepth(root.right);
		if (l == 0 || r == 0) {
			return l + r + 1; // 第二、四、五种情况
		}
		return l > r ? r + 1 : l + 1; // 第三种情况
	}

}
