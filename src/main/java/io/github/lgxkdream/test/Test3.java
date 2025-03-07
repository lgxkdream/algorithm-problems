package io.github.lgxkdream.test;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test3
 * @description
 * @since 2020-04-02 21:40
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(Integer.toString(22934820, 36));
        String s = Long.toString(3L, 36);
        System.out.println(s);
        System.out.println(myDec(22934820, 188));
    }

    public static String myDec(int number, int n) {
        // String 是不可变的，每次改变都要新建一个Strng，很浪费时间。
        // StringBuilder是‘可变的String’ ,
        StringBuilder result = new StringBuilder();
        // 模拟计算进制的过程
        while (number > 0) {
            result.insert(0, number % n);
            number /= n;
        }
        return result.toString();
    }

}
