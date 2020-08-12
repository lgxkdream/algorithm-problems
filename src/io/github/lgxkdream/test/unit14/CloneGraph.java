package io.github.lgxkdream.test.unit14;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 133. 克隆图
 * @description https://leetcode-cn.com/problems/clone-graph/
 * @since 2020-08-12 10:05
 */
public class CloneGraph {

    public static void main(String[] args) {
        /**
         * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
         * 输出：[[2,4],[1,3],[2,4],[1,3]]
         * 解释：
         * 图中有 4 个节点。
         * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
         * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
         * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
         * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
         */
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        Node nodeClone = cloneGraph(node1);
        System.out.println(node1.neighbors.stream().map(node -> node.val).collect(Collectors.toList()));
        System.out.println(node2.neighbors.stream().map(node -> node.val).collect(Collectors.toList()));
        System.out.println(node3.neighbors.stream().map(node -> node.val).collect(Collectors.toList()));
        System.out.println(node4.neighbors.stream().map(node -> node.val).collect(Collectors.toList()));
    }

    private static Map<Node, Node> clonedMap = new HashMap<>();

    /**
     * 递归思想
     *
     * @param node
     * @return
     */
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // 判断是否克隆过
        if (clonedMap.containsKey(node)) {
            return clonedMap.get(node);
        }
        // 克隆当前节点
        Node cloneNode = new Node(node.val);
        // 标记为已克隆
        clonedMap.put(node, cloneNode);
        // 克隆节点的邻居列表
        cloneNode.neighbors = node.neighbors.stream().map(n -> cloneGraph(n)).collect(Collectors.toList());
        return cloneNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
