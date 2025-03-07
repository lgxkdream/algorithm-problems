package io.github.lgxkdream.unit13;

import io.github.lgxkdream.common.TreeNode;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 508. 出现次数最多的子树元素和
 * @description
 * @since 6/19/22 10:03 PM
 */
public class MostFrequentSubtreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
        /**
         * 输出: [2,-3,4]
         */
        System.out.println(Arrays.toString(findFrequentTreeSum(root)));
        root = new TreeNode(5, new TreeNode(2), new TreeNode(-5));
        /**
         * 输出: [2]
         */
        System.out.println(Arrays.toString(findFrequentTreeSum(root)));
    }

    private static int maxCount = 0;

    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + dfs(root.left, map) + dfs(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, map.get(sum));
        return sum;
    }


}
