package io.github.lgxkdream.test.unit14;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 632. 最小区间
 * @description https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/
 * @since 2020-08-01 23:46
 */
public class SmallestRangeCoveringElementsFromKLists {

    public static void main(String[] args) {
        List l1 = Lists.newArrayList(4, 10, 15, 24, 26);
        List l2 = Lists.newArrayList(0, 9, 12, 20);
        List l3 = Lists.newArrayList(5, 18, 22, 30);
        List l = Lists.newArrayList(l1, l2, l3);
        /**
         * 输出: [20,24]
         * 解释:
         * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
         * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
         * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
         */
        System.out.println(Arrays.toString(smallestRange(l)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int inf = (int) 1e5;
        int max = -inf; // 当前最大值
        int st = -inf;  // 起点
        int ed = inf;   // 终点
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        // 相当于合并k个有序链表，把 head 放进去
        for (int i = 0; i < n; i++) {
            int val = nums.get(i).get(0);
            pq.offer(new Node(i, 0, val));
            max = Math.max(max, val);
        }
        // 必须包含 k 个元素
        while (pq.size() == n) {
            Node node = pq.poll();
            int i = node.i;
            int j = node.j;
            int val = node.val;

            // 更新区间长度
            if (max - val < ed - st) {
                st = val;
                ed = max;
            }

            // 为堆中填充元素
            if (j + 1 < nums.get(i).size()) {
                int nVal = nums.get(i).get(j + 1);
                pq.offer(new Node(i, j + 1, nVal));
                max = Math.max(max, nVal);
            }
        }
        return new int[]{st, ed};
    }

}

class Node {
    int i, j, val;

    public Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
