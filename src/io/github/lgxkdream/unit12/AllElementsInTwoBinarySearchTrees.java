package io.github.lgxkdream.unit12;

import io.github.lgxkdream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1305. 两棵二叉搜索树中的所有元素
 * @description https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 * @since 5/1/22 8:29 AM
 */
public class AllElementsInTwoBinarySearchTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));
        /**
         * 输出：[0,1,1,2,3,4]
         */
        getAllElements(root1, root2).forEach(System.out::println);

        System.out.println("==========================");

        root1 = new TreeNode(1, null, new TreeNode(8));
        root2 = new TreeNode(8, new TreeNode(1), null);
        /**
         * 输出：[1,1,8,8]
         */
        getAllElements(root1, root2).forEach(System.out::println);
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> root1Vals = new ArrayList<>();
        List<Integer> root2Vals = new ArrayList<>();
        inorderTraversal(root1Vals, root1);
        inorderTraversal(root2Vals, root2);

        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < root1Vals.size() || p2 < root2Vals.size()) {
            Integer root1Val = null, root2Val = null;
            if (p1 < root1Vals.size()) {
                root1Val = root1Vals.get(p1);
            }
            if (p2 < root2Vals.size()) {
                root2Val = root2Vals.get(p2);
            }
            if (root1Val != null && root2Val != null) {
                if (root1Val < root2Val) {
                    res.add(root1Val);
                    p1++;
                } else {
                    res.add(root2Val);
                    p2++;
                }
            } else if (root1Val != null) {
                res.add(root1Val);
                p1++;
            } else if (root2Val != null) {
                res.add(root2Val);
                p2++;
            }
        }
        return res;
    }

    private static void inorderTraversal(List<Integer> rootVals, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(rootVals, root.left);
        rootVals.add(root.val);
        inorderTraversal(rootVals, root.right);
    }

}
