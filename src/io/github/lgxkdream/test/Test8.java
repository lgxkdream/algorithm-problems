package io.github.lgxkdream.test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-05 21:04
 */
public class Test8 {

    static final Lock lock = new ReentrantLock();
    static final Condition notFull = lock.newCondition();
    // static final Condition notEmpty = lock.newCondition();
    static final Object[] items = new Object[10];
    static volatile int putptr, takeptr, count;

    public static void put(Object x) throws InterruptedException {
        try {
            lock.lock();
            while (count == items.length) {
                System.out.println("添加满了阻塞中");
                notFull.await();
                System.out.println("被唤醒，继续添加元素");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            // notEmpty.signal();
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }

    public static Object take() throws InterruptedException {
        try {
            lock.lock();
            while (count == 0) {
                System.out.println("提取没了阻塞中");
                // notEmpty.await();
                notFull.await();
                System.out.println("恢复，继续提取元素");
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 13; i++) {
                try {
                    put("abc");
                    System.out.println(Thread.currentThread().getName() + "--put--" + count + "个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true){
                try {
                    System.out.println(Thread.currentThread().getName() + "--take--" + take() + " " + Arrays.toString(items));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
        t1.start();
    }

}
