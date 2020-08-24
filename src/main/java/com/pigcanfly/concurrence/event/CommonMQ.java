package com.pigcanfly.concurrence.event;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tobbyquinn
 * @date 2020/03/31
 */
public class CommonMQ {
    private CommonMQ() {
    }

    private static final CommonMQ mq = new CommonMQ();

    public static CommonMQ singleton() {
        return mq;
    }

    private final LinkedBlockingQueue QUEUE = new LinkedBlockingQueue(100);

    boolean add(Object t) {
        return QUEUE.add(t);
    }

    Object poll() {
        return QUEUE.poll();
    }

    boolean isEmpty() {
        return QUEUE.isEmpty();
    }

    Object take() throws InterruptedException {
        return QUEUE.take();
    }

}
