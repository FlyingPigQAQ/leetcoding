package com.pigcanfly.leetcoding.s190;

/**
 * @author tobbyquinn
 * @date 2019/11/19
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res=0;
        for (int i = 0; i < 32; i++) {
            if(((n>>i)&1)==1){
                if(i==31){
                    res|=1;
                }else{
                    res|=2<<(30-i);
                }
            }
        }
        return res;
    }
}
