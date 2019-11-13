package io.github.lgxkdream.common;

/**
 * 树节点
 */
public class TreeNode {

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public int val;
    public TreeNode left;
    public TreeNode right;
    public int maxLeft;
    public int maxRight;

}
