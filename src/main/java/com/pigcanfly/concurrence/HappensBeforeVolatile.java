package com.pigcanfly.concurrence;

/**
 * @author tobbyquinn
 * @date 2020/05/09
 */
public class HappensBeforeVolatile {
    private static volatile int x = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                Thread.sleep(4000);

                System.out.println("SubThread read x=" + x);
                x = 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        System.out.println("MainThread read x=" + x);
        x = 3;
        System.out.println("MainThread read x=" + x);

    }
}
