package com.pigcanfly.concurrence.pool;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author tobbyquinn
 * @date 2020/02/16
 */
public class ObjectPoolv1<T> {
    private Semaphore lock = null;
    private List<T> pools = new Vector<>();


    public ObjectPoolv1(int poolSize, T t) {
        lock = new Semaphore(poolSize);
        try {
            for (int i = 0; i < poolSize; i++) {
                T o = (T) t.getClass().newInstance();
                pools.add(o);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public T get() {
        T obj = null;
        try {
            lock.acquire();
            obj = pools.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public void release(T t) {
        if (t == null) {
            return;
        }
        pools.add(t);
        lock.release();
    }

    public static void main(String[] args) {
        DbInfor dbInfor = new DbInfor("齐遥", "123456");
        final ObjectPoolv1<DbInfor> pool = new ObjectPoolv1<>(3, dbInfor);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                DbInfor db = null;
                try {
                    db = pool.get();
                    System.out.println(db + " " + Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    pool.release(db);
                }
            });
        }

    }
}
