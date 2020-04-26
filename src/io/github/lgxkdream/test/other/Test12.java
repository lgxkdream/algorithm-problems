package io.github.lgxkdream.test.other;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test12
 * @description
 * @since 2020-02-21 17:35
 */
public class Test12 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node21 = new TreeNode(9);
        TreeNode node22 = new TreeNode(20);
        /*TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);*/
        TreeNode node42 = new TreeNode(15);
        TreeNode node41 = new TreeNode(7);

        node1.left = node21;
        node1.right = node22;
        // node21.left = node31;
        node21.right = node41;
        node22.left = node42;
        // node22.right = node32;
        List<List<Integer>> lists = levelOrderBottom(node1);
        for (List<Integer> list : lists) {
            StringUtils.join(",", list);
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        return null;
    }

}
