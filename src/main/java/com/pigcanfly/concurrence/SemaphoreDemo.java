package com.pigcanfly.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author tobbyquinn
 * @date 2020/02/16
 */
public class SemaphoreDemo {
    final static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);


        executorService.submit(()->{
            try {
                semaphore.acquire();
                System.out.println("do something "+Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        });
        Thread.sleep(2000);
        executorService.shutdownNow();
        System.out.println("主线程结束");
    }
}
