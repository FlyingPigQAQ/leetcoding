package com.pigcanfly.leetcoding.s299;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/12/18
 */
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int[] cacheA = new int[10];
        int[] cacheB = new int[10];
        int bulls=0,cows=0;
        for (int i = 0; i < guess.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if(sc==gc){
                bulls++;
            }else {
                cacheA[sc-'0']++;
                cacheB[gc-'0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows+=cacheB[i]!=0?Math.min(cacheA[i],cacheB[i]):0;
        }
        return bulls+"A"+cows+"B";
    }
}
