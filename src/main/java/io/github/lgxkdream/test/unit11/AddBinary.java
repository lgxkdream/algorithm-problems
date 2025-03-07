package io.github.lgxkdream.test.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 67. 二进制求和
 * @description
 * @since 2020-06-23 10:07
 */
public class AddBinary {

    public static void main(String[] args) {
        /**
         * 输出: "100"
         */
        System.out.println(addBinary("11", "1"));
        /**
         * 输出: "10101"
         */
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        int aindex = achars.length - 1, bindex = bchars.length - 1, sum = 0;
        while (aindex >= 0 || bindex >= 0 || sum > 0) {
            if (aindex >= 0) {
                sum += achars[aindex--] - '0';
            }
            if (bindex >= 0) {
                sum += bchars[bindex--] - '0';
            }
            sb.append(sum % 2);
            sum = sum / 2;
        }
        return sb.reverse().toString();
    }

}
