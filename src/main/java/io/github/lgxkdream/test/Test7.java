package io.github.lgxkdream.test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-04-28 21:13
 */
public class Test7 {

    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        final AtomicBoolean flag = new AtomicBoolean();

        Runnable runnable = () -> {
            // try {
                // lock.lockInterruptibly();
                synchronized (Test7.class) {
                while (true) {
                    try {
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + " run");
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " InterruptedException");
                        break;
                    }
                    if (flag.get()) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
                }
            // } catch (InterruptedException e) {
            //     System.out.println(Thread.currentThread().getName() + "中断了");
            //     flag.set(true);
            // } finally {
                // lock.unlock();
            // }
        };

        Thread t1 = new Thread(runnable, "线程t1");
        Thread t2 = new Thread(runnable, "线程t2");
        t1.start();
        t2.start();

        Thread.sleep(2000);
        t1.interrupt();
        System.out.println("t1.interrupt()");
        t2.interrupt();
        System.out.println("t2.interrupt()");


        // int result = 0;
        // int[] a = {4, 8, 2, 5, 6, 1, 8};
        // System.out.println(findrep(a));


        // Arrays.sort(a);
        // for (int i : a) {
        //     int b = result;
        //     result = result ^ i;
        //     if (b == result) {
        //         System.out.println(i);
        //     }
        // }
        // System.out.println("无");
    }

    static int findrep(int a[]) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp = temp ^ a[i];
        }
        return temp ^ (a.length - 1);
    }

}
