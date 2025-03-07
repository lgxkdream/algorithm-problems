package io.github.lgxkdream.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-26 18:22
 */
public class Test12 {

    private static Thread t;

    private static void test() {
        ThreadLocal<Object> local = new ThreadLocal<>();
        local.set(null);
        local.get();
        local.remove();
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
                LockSupport.unpark(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void yunxing() {
        t = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.println("业务逻辑");
            }
        });
        t.start();
    }

    public static void main(String[] args) throws Exception {
        yunxing();
        test();

        // ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        // ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        // ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        // readLock.lock();
        // System.out.println(1);
        // writeLock.lock();
        // System.out.println(2);
        // System.out.println("sljdfl");
        // writeLock.unlock();
        // readLock.unlock();
        //
        // writeLock.lock();
        // readLock.lock();
        // writeLock.lock();
        // System.out.println("aaaaaa");
        // writeLock.unlock();
        // readLock.unlock();
        // writeLock.unlock();

        /**
         * 10个 1G   10G
         * 512M 20个文件
         * 前1000个最多的
         * http://doc.okbase.net/zyq522376829/archive/169290.html
         */

        /**
         * 25
         * 1 2 3 4 5
         * 6 7 8 9 10
         * 11 12
         * 5
         * https://my.oschina.net/alarm1673/blog/701829?from=mail-notify
         */
    }

}
