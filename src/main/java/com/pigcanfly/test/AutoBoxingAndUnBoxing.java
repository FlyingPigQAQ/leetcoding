package com.pigcanfly.test;

/**
 * 性能差5-10倍
 * @author Tobby Quinn
 * @date 2019/08/19
 */
public class AutoBoxingAndUnBoxing {

    public static void main(String[] args) {
        int times=1000000000;


        long start1 = System.currentTimeMillis();
        normal(times);
        long end1 = System.currentTimeMillis();
        System.out.println("normal: "+(end1-start1)+"ms");

        long start = System.currentTimeMillis();
        autoBoxAndUnBoxing(times);
        long end = System.currentTimeMillis();
        System.out.println("autoBoxAndUnBoxing: "+(end-start)+"ms");
    }

    public static void autoBoxAndUnBoxing(int times){
        for (int i = 0; i < times; i++) {
            Integer ints =i; //boxing
            ints++;     //unboxing
        }
    }
    public static void normal(int times){
        for (int i = 0; i < times; i++) {
            int ints =i;
            ints++;
        }
    }
}
