package io.github.lgxkdream.test.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 等式方程的可满足性
 * @description https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * @since 2020-06-08 10:06
 */
public class SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        /**
         * 输出：false
         * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
         */
        System.out.println(equationsPossible(new String[]{"a==b", "b!=a"}));

        /**
         * 输出：true
         * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
         */
        System.out.println(equationsPossible(new String[]{"b==a", "a==b"}));

        /**
         * 输出：true
         */
        System.out.println(equationsPossible(new String[]{"a==b", "b==c", "a==c"}));

        /**
         * 输出：false
         */
        System.out.println(equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));

        /**
         * 输出：true
         */
        System.out.println(equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }

    public static boolean equationsPossible(String[] equations) {
        // int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

}
