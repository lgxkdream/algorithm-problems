package io.github.lgxkdream.test.other;

import java.util.concurrent.Executors;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test13
 * @description 青蛙跳台阶
 * @since 2020-03-02 09:15
 */
public class Test13 {

    public static void main(String[] args) {
        System.out.println(JumpFloor(44));
        System.out.println(JumpFloorI(10));
        System.out.println(JumpFloorII(10));
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
    }

    public static int JumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        int a = 1;
        int b = 2;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static int JumpFloorI(int target) {
        if (target < 3) {
            return target;
        }
        return JumpFloorI(target - 1) + JumpFloorI(target - 2);
    }

    /**
     *
     * https://blog.csdn.net/dream_one_day/article/details/98229656
     *
     * f(n) = f(n-1) + f(n-2) + f(n-3) + … + f(0)
     * f(n-1) = f(n-2) + f(n-3) + f(n-4) +… +f(0)
     * 两式联合可以推出 f(n) = 2 * f(n-1)
     *
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        if (target < 3) {
            return target;
        }
        return 2 * JumpFloorII(target - 1);
    }

}
