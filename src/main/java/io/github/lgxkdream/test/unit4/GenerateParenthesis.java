package io.github.lgxkdream.test.unit4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title GenerateParenthesis
 * @description https://leetcode-cn.com/problems/generate-parentheses/
 * @since 2020-04-09 09:50
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> stringList = generateParenthesis(3);
        System.out.println(stringList);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, n, n, "");
        return result;
    }

    public static void generateParenthesis(List<String> result, int l, int r, String str) {
        if (l <= 0 && r <= 0) {
            result.add(str);
        }
        if (l > 0) {
            generateParenthesis(result, l - 1, r, str + "(");
        }
        if (r > l) {
            generateParenthesis(result, l, r -1, str + ")");
        }
    }

}
