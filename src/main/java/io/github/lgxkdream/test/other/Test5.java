package io.github.lgxkdream.test.other;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author LiGang
 * @version 1.0.0
 * @title Test5
 * @description
 * @since 2020-01-16 18:06
 */
public class Test5 {

    private static long[] arr = new long[1000];

    public static void main(String[] args) throws InterruptedException {
        StopWatch started = StopWatch.createStarted();
        System.out.println(f(300));
        started.stop();
        System.out.println("时长：" + started.getTime());
        started.reset();
        started.start();
        System.out.println(f1(50));
        // TimeUnit.SECONDS.sleep(1);
        started.stop();
        System.out.println("时长：" + started.getTime());
    }

    static long f1(int n) {
        if (n <= 2) {
            return n;
        }
        return f1(n - 1) + f1(n - 2);
    }

    static long f(int n) {
        if (n <= 2) {
            return n;
        }
        //先判断有没计算过
        // System.out.println(arr[n]);
        if (arr[n] != 0) {
            //计算过，直接返回
            return arr[n];
        } else {
            // 没有计算过，递归计算,并且把结果保存到 arr数组里
            arr[n] = f(n - 1) + f(n - 2);
            return arr[n];
        }
    }

}
