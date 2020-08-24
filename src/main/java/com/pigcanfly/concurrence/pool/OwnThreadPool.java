package com.pigcanfly.concurrence.pool;

import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者-消费者模式
 *
 * @author tobbyquinn
 * @date 2020/03/22
 */
public class OwnThreadPool {

    LinkedBlockingQueue<Runnable> queue = null;
    LinkedHashSet<Thread> threads = new LinkedHashSet<>();

    //
    public OwnThreadPool(int coreSize, int queueSize) {
        queue = new LinkedBlockingQueue<Runnable>(queueSize);
        for (int i = 0; i < coreSize; i++) {
            //构造线程池
            WorkThread workThread = new WorkThread();
            threads.add(workThread);
            workThread.start();
        }
    }
    public void execute(Runnable r){
        queue.offer(r);
    }


    class WorkThread extends Thread {

        @Override
        public void run() {

            while (true) {
                Runnable r = null;
                try {
                    r = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r.run();
            }
        }
    }

    public static void main(String[] args) {
        OwnThreadPool ownThreadPool = new OwnThreadPool(3, 10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            ownThreadPool.execute(()->{
                System.out.println(finalI);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
