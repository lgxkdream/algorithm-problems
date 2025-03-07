package io.github.lgxkdream.test;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test1
 * @description
 * @since 2020-03-22 13:52
 */
public class Test1 {

    public static void main(String[] args) {
        String a = "12343";
        String b = "9876";
        String aReverse = new StringBuilder(a).reverse().toString();
        String bReverse = new StringBuilder(b).reverse().toString();
        System.out.println(add(aReverse, bReverse));
    }

    private static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int al = a.length();
        int bl = b.length();
        int i = 0;
        int yu = 0;
        while (i < al && i < bl) {
            int aa = getNumByIndex(a, i);
            int bb = getNumByIndex(b, i);
            int cc = aa + bb + yu;
            sb.append(cc % 10);
            yu = cc / 10;
            i++;
        }
        if (al > bl) {
            appendLast(i, al, sb, yu, a);
        } else {
            appendLast(i, bl, sb, yu, b);
        }
        return sb.reverse().toString();
    }

    private static void appendLast(int i, int al, StringBuilder sb, int yu, String a) {
        while (i < al) {
            int num = getNumByIndex(a, i);
            int cc = num + yu;
            sb.append(cc % 10);
            yu = cc / 10;
            sb.append(cc % 10);
            i++;
        }
    }

    private static int getNumByIndex(String str, int index) {
        return Integer.valueOf(String.valueOf(str.charAt(index)));
    }

}
