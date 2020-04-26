package io.github.lgxkdream.test.unit3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title ShortEncodingOfWords
 * @description https://leetcode-cn.com/problems/short-encoding-of-words/
 * @since 2020-03-28 10:36
 */
public class ShortEncodingOfWords {

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
        // Arrays.sort(words, Comparator.comparingInt(String::length));
        // System.out.println("time".indexOf("me"));
        // for (String word : words) {
        //     System.out.println(word);
        // }
    }

    public static int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;

    }

    static class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }



    public static int minimumLengthEncoding1(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        StringBuilder sb = new StringBuilder(words[words.length - 1] + "#");
        for (int i = words.length - 2; i >= 0; i--) {
            String word = words[i] + "#";
            if (sb.indexOf(word) == -1) {
                sb.append(word);
            }
        }
        return sb.length();
    }

}
