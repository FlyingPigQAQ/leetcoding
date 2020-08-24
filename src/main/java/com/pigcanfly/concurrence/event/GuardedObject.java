package com.pigcanfly.concurrence.event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author tobbyquinn
 * @date 2020/03/31
 */
public class GuardedObject<T> {
    private T obj;

    private Lock lock = new ReentrantLock();
    private Condition done = lock.newCondition();
    private static Map<Object, GuardedObject> guardedObjectMap = new ConcurrentHashMap();

    private GuardedObject() {
    }

    static <K> GuardedObject create(K key) {
        GuardedObject guardedObject = new GuardedObject();
        guardedObjectMap.put(key, guardedObject);
        return guardedObject;
    }

    T get(Predicate<T> p) {
        lock.lock();
        try {
            while (!p.test(obj)) {
                //超时等待 或 线程唤醒
                done.await(5, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return obj;
    }

    static <K, T> void fireEvent(K key, T obj) {
        GuardedObject<T> go = guardedObjectMap.remove(key);
        if (go != null) {
            go.onChange(obj);
        }

    }

    void onChange(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            //唤醒线程
            done.signalAll();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
