package io.github.lgxkdream.test.unit14;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 43. 字符串相乘
 * @description https://leetcode-cn.com/problems/multiply-strings/
 * @since 2020-08-13 10:08
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        /**
         * 输出: "6"
         */
        System.out.println(multiply("2", "3"));
        /**
         * 输出: "56088"
         */
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String result = "0";
        int len = num2.length(), index = len - 1;
        while (index >= 0) {
            int zeroNum = len - 1 - index;
            String multiplySingle = multiplySingle(num1, num2.charAt(index--) - '0');
            while (zeroNum-- > 0) {
                multiplySingle += "0";
            }
            result = add(result, multiplySingle);
        }
        return result;
    }

    private static String multiplySingle(String num, int singleNum) {
        int index = num.length() - 1, product = 0;
        StringBuilder sb = new StringBuilder();
        while (index >= 0 || product != 0) {
            if (index >= 0) {
                product += (num.charAt(index--) - '0') * singleNum;
            }
            sb.append(product % 10);
            product = product / 10;
        }
        return sb.reverse().toString();
    }

    private static String add(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() - 1, sum = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || sum > 0) {
            if (index1 >= 0) {
                sum += num1.charAt(index1--) - '0';
            }
            if (index2 >= 0) {
                sum += num2.charAt(index2--) - '0';
            }
            sb.append(sum % 10);
            sum = sum / 10;
        }
        return sb.reverse().toString();
    }

}
