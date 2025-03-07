package io.github.lgxkdream.test.unit16;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 557. 反转字符串中的单词 III
 * @description
 * @since 2020-08-30 20:03
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        /**
         * 输出："s'teL ekat edoCteeL tsetnoc"
         */
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        return Arrays.stream(s.split(" ")).map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
    }

}
