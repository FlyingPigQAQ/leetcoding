package com.pigcanfly.concurrence.pool;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 改进:业务代码不去释放资源，而是将控制权给了对象池
 *
 * @author tobbyquinn
 * @date 2020/02/16
 */
public class ObjectPoolv2<T, R> {
    private Semaphore lock = null;
    private List<T> pools = new Vector<>();


    public ObjectPoolv2(int poolSize, T t) {
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

    public R exec(Function<T, R> function) {
        T obj = null;
        try {
            lock.acquire();
            obj = pools.remove(0);
            return function.apply(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pools.add(obj);
            lock.release();
        }
        return null;
    }


    public static void main(String[] args) {
        DbInfor dbInfor = new DbInfor("齐遥", "123456");
        final ObjectPoolv2 pool = new ObjectPoolv2<>(1, dbInfor);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                String res = (String) pool.exec(p ->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return p.toString().toUpperCase();});
                System.out.println(res+" "+Thread.currentThread().getName());

            });
        }

    }
}
