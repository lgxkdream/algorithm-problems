package io.github.lgxkdream.test.unit4;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title AddStrings
 * @description https://leetcode-cn.com/problems/add-strings/
 * @since 2020-04-01 10:54
 */
public class AddStrings {

    public static void main(String[] args) {
        String num1 = "2342";
        String num2 = "9872";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int sum = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || sum != 0) {
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            sb.append(sum % 10);
            sum = sum / 10;
        }
        return sb.reverse().toString();
    }

}
