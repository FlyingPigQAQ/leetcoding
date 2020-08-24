package com.pigcanfly.concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tobbyquinn
 * @date 2020/02/07
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        System.out.println(condition==null);

    }
}
