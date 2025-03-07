package io.github.lgxkdream.test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test4
 * @description
 * @since 2020-04-06 21:29
 */
public class Test4 {

    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock(19, TimeUnit.MILLISECONDS);
        lock.unlock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock().lock();
        StampedLock stampedLock = new StampedLock();
        stampedLock.readLock();
        /**
         * new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>());
         */
        Executors.newCachedThreadPool();
        /**
         * new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         */
        Executors.newFixedThreadPool(10);
        /**
         * new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         */
        Executors.newSingleThreadExecutor();
    }

}
