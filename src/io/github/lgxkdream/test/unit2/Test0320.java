package io.github.lgxkdream.test.unit2;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test0320
 * @description
 * @since 2020-03-20 11:58
 */
public class Test0320 {

    public static void main(String[] args) {
        String a = "888888888888913";
        String b = "222222222222107";
        System.out.println(add1(a, b));
        System.out.println(getCharIntegerValueOfString("312342", 4));
        System.out.println(Integer.valueOf(String.valueOf("312342".charAt(4))));
        char c = "312342".charAt(4);
        System.out.println(c);
        System.out.println((int) c);
        // System.out.println(getCharIntegerValueOfString("2312344", 2));
        // System.out.println(getSum(34, 56));
    }

    public static String add1(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        //进位
        int bonus = 0;
        while (i >= 0 || j >= 0) {
            int sum = getCharIntegerValueOfString(a, i--) + getCharIntegerValueOfString(b, j--) + bonus;
            //保存和的个位部分
            builder.append(sum % 10);
            //计算是否有进位，如果sum为11，进位为1
            bonus = sum / 10;
        }
        if (bonus > 0) {
            builder.append(bonus);
        }
        //string反转输出
        return builder.reverse().toString();
    }

    public static int getSum(int a, int b) {
        if ((a & b) != 0) {
            return getSum(a ^ b, (a & b) << 1);
        } else {
            return a | b;
        }
    }



    private static int getCharIntegerValueOfString(String s, int index) {
        return index < 0 ? 0 : s.charAt(index);
    }

}
