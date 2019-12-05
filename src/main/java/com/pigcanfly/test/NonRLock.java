package com.pigcanfly.test;

/**
 * @author tobbyquinn
 * @date 2019/11/26
 */
public class NonRLock {

    public static void main(String[] args) throws InterruptedException {
        NRLock lock = new NRLock();
        lock.lock();
        System.out.println("Hello First");
        lock.unLock();
        lock.lock();
        System.out.println("Hello Second");
        lock.unLock();
        //模拟递归进入同一把锁
        lock.lock();
        System.out.println("Hello Third");
        lock.lock();
        System.out.println("Hello Four");
        lock.unLock();
        lock.unLock();
    }
}

class NRLock {
    private volatile boolean lock = false;

    public synchronized void lock() throws InterruptedException {
        while (lock) {
            wait();
        }
        lock=true;
    }

    public synchronized void unLock() throws InterruptedException {
        lock=false;
        notify();
    }
}
