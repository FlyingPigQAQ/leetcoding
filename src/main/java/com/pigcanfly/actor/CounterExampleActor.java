package com.pigcanfly.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 基于ForkJoinPool模型
 * @author tobbyquinn
 * @date 2020/04/05
 */
public class CounterExampleActor {
    public static class CounterActor extends UntypedAbstractActor {
        private int counter = 0;

        @Override
        public void onReceive(Object message) throws Throwable {
            System.out.println(Thread.currentThread().getName());
            if (message instanceof Number) {
                counter += ((Number) message).intValue();
            }else {
                System.out.println(counter);
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    public static void main(String[] args) {
        //创建ActorSystem
        final ActorSystem actorSystem = ActorSystem.create("HelloActor");

        ActorRef actorRef = actorSystem.actorOf(Props.create(CounterActor.class));
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(() -> {
                for (int j = 0; j < 10000; j++) {
                    actorRef.tell(1, ActorRef.noSender());
                }
            });
        }
        threadPool.shutdown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        actorRef.tell("", ActorRef.noSender());
        actorSystem.terminate();

    }
}
