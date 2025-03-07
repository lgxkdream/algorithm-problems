package io.github.lgxkdream.unit13;

import io.github.lgxkdream.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 515. 在每个树行中找最大值
 * @description https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * @since 2022-06-24 20:15
 */
public class FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
        TreeNode p2 = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        TreeNode p3 = new TreeNode(2, null, new TreeNode(9));
        TreeNode p1 = new TreeNode(1, p2, p3);
        System.out.println(largestValues(p1));
    }

    public static List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getKey(), entry.getValue());
        }
        return res;
    }

    private static void dfs(TreeNode root, int curHeight, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(curHeight, Math.max(root.val, map.getOrDefault(curHeight, Integer.MIN_VALUE)));
        dfs(root.left, curHeight + 1, map);
        dfs(root.right, curHeight + 1, map);
    }

}
