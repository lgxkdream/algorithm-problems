package io.github.lgxkdream.test.unit15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 17. 电话号码的字母组合
 * @description https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 * @since 2020-08-26 23:26
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        /**
         * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
         */
        System.out.println(letterCombinations("23"));
    }

    /**
     * 回溯思想
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        letterCombinations(phoneMap, digits, result, new StringBuilder());
        return result;
    }

    private static void letterCombinations(Map<Character, String> phoneMap, String digits, List<String> result, StringBuilder subResult) {
        if (subResult.length() == digits.length()) {
            result.add(subResult.toString());
        } else {
            String letters = phoneMap.get(digits.charAt(subResult.length()));
            for (int i = 0; i < letters.length(); i++) {
                subResult.append(letters.charAt(i));
                letterCombinations(phoneMap, digits, result, subResult);
                subResult.deleteCharAt(subResult.length() - 1);
            }
        }
    }

}
