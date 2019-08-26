package com.pigcanfly.leetcoding.s1114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author Tobby Quinn
 * @date 2019/08/15
 */
public class Foo {
    java.util.concurrent.Semaphore run2,run3;
    public Foo() {
         run2 = new java.util.concurrent.Semaphore(0);
         run3 = new java.util.concurrent.Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable first = new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        };
        Runnable second = new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        };
        Runnable third = new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        };
        new Thread(()->{
            try {
                countDownLatch.await();
                foo.first(first);
            }catch (Exception e){
                e.printStackTrace();
            }

        },"t1").start();
        new Thread(()->{
            try {
                countDownLatch.await();
                foo.second(second);
            }catch (Exception e){
                e.printStackTrace();
            }

        },"t2").start();
        new Thread(()->{
            try {
                countDownLatch.await();
                foo.third(third);
            }catch (Exception e){
                e.printStackTrace();
            }

        },"t3").start();
        for (int i = 0; i < 3; i++) {
            countDownLatch.countDown();
        }
    }
}
