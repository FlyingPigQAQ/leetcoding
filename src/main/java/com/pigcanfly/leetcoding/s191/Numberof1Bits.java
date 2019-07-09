package com.pigcanfly.leetcoding.s191;

/**
 * @author Tobby Quinn
 * @date 2019/07/03
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            n&=n-1;
            res++;
        }
        return res;
    }
}
