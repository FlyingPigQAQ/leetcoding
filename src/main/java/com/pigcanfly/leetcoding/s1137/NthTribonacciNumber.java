package com.pigcanfly.leetcoding.s1137;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/09/04
 */
public class NthTribonacciNumber {
    // undo 37 6s Value:2082876103
    private static HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
    public static int tribonacci(int n) {
        if(n<2){
            cache.put(0,0);
            cache.put(1,1);
            return n;
        }
        if(n==2){
            cache.put(2,1);
            return 1;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int n1 = tribonacci(n-1);
        cache.put(n-1,n1);
        return n1+tribonacci(n-3)+tribonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(37));
    }
}
