package com.pigcanfly.leetcoding.s69;

/**
 * @author tobbyquinn
 * @date 2019/12/07
 */
public class Sqrtx {
    /**
     *
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        long i=0;
        for(;i*i<=x;i++){
            if(i*i==x){
                return (int)i;
            }
        }
        return (int) (i-1);
    }

    public int mySqrt(int x) {
        long left=0,right=x;
        while(left<=right){
            long mid = left+((right-left)>>1);
            long res=mid*mid;
            if(res==x){
                return (int)mid;
            }else if(res<x){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return (int)(left-1);
    }
}
