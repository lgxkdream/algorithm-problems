package io.github.lgxkdream.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-27 20:11
 */
public class MyLock extends AbstractQueuedSynchronizer {

    /**
     * 锁定
     */
    public void lock(){
        acquire(1);
    }

    /**
     * 尝试锁定
     */
    public boolean tryLock(){
        return tryAcquire(1);
    }

    /**
     * 解锁
     */
    public void unlock(){
        release(1);
    }

    /**
     * 是否为锁定
     */
    public boolean isLocked(){
        return isHeldExclusively();
    }


    /**
     * 尝试获取锁
     */
    @Override
    protected boolean tryAcquire(int arg) {
        if(compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    /**
     * 尝试释放锁
     */
    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
