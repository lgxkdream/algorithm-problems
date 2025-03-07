package io.github.lgxkdream.test;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-04-26 20:54
 */
public class DeadLock {
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (obj1) {
                System.out.println("Lock1 lock obj1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("Lock1 lock obj2");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (obj2) {
                System.out.println("Lock2 lock obj2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("Lock2 lock obj1");
                }
            }
        }).start();
    }
}