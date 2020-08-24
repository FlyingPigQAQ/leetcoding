package com.pigcanfly.concurrence.event;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tobbyquinn
 * @date 2020/03/31
 */
public class Main {
    public static void main(String[] args) {
        //启动消费线程
        new WebConsumer().start();

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //生产者
        for (int i = 0; i < 10; i++) {
            final String orderId= UUID.randomUUID().toString();
            threadPool.submit(()->{
                System.out.println(Thread.currentThread().getName());
                String result = new WebProvider().buy(orderId);
                System.out.println(result);
            });
        }


    }
}
