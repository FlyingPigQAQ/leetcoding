package com.pigcanfly.leetcoding.s441;

/**
 * @author tobbyquinn
 * @date 2019/12/16
 */
public class ArrangingCoins {
    public int arrangeCoins1(int n) {
        int i=1;
        while (i<=n){
            n-=i;
            i++;
        }
        return i-1;
    }
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2L*n+0.25)-0.5);
    }
}
