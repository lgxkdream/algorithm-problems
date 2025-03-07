package io.github.lgxkdream.test.unit1;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title CountCharacters
 * @description https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 * @since 2020-03-17 15:55
 */
public class CountCharacters {

    public static void main(String[] args) {
        /**
         * 输出：6
         * 解释：
         * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
         */
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        /**
         * 输出：10
         * 解释：
         * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
         */
        System.out.println(countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        String result = "";
        char[] chars2 = chars.toCharArray();
        Arrays.sort(chars2);
        int l2 = chars2.length;
        for (String word : words) {
            char[] chars1 = word.toCharArray();
            Arrays.sort(chars1);
            int l1 = chars1.length;
            int count = 0;
            int index = 0;
            for (char c1 : chars1) {
                for (int j = index; j < l2; j++) {
                    if (c1 == chars2[j]) {
                        index = j + 1;
                        count++;
                        break;
                    }
                }
            }
            if (count == l1) {
                result = result + word;
            }
        }
        return result.length();
    }

}
