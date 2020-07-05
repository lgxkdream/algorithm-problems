package io.github.lgxkdream.test;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-29 20:32
 */
public class Test20 {

    public static void main(String[] args) {
        String a = "24354325436547675687698708700";
        String b = "134536435654776774575347457";
        String result = add(a, b);
        System.out.println(result);
    }

    private static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int alen = aChars.length - 1, blen = bChars.length - 1, sum = 0;
        while (alen >= 0 || blen >= 0 || sum != 0) {
            if (alen >= 0) {
                sum += aChars[alen--] - '0';
            }
            if (blen >= 0) {
                sum += bChars[blen--] - '0';
            }
            sb.append(sum % 10);
            sum = sum / 10;
        }
        return sb.reverse().toString();
    }

}
