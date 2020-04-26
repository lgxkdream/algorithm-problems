package io.github.lgxkdream.test.unit1;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title CountCharacters
 * @description
 * @since 2020-03-17 15:55
 */
public class CountCharacters {

    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        String result = "";
        for (String word : words) {
            char[] chars1 = word.toCharArray();
            char[] chars2 = chars.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            int l1 = chars1.length;
            int l2 = chars2.length;
            int count = 0;
            int index = 0;
            for (char c1 : chars1) {
                for (int j = index; j< l2; j++) {
                    if (c1 == chars2[j]) {
                        index = j + 1;
                        count ++;
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
