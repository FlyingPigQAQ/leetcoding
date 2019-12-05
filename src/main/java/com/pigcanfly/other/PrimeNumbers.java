package com.pigcanfly.other;

/**
 * @author tobbyquinn
 * @date 2019/10/29
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        outer:for (int i = 3; i <=100; i++) {
            for (int j = 2; j*j<=i ; j++) {
                if(i%j==0){
                    continue outer;
                }
            }
            System.out.print(i+",");
        }
    }
}
