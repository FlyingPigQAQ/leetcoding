package com.pigcanfly.leetcoding.s1085;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class SumofDigitsintheMinimumNumber {
    public int sumOfDigits(int[] A) {
        int min=Integer.MAX_VALUE;
        for (int i : A) {
            min=Math.min(i,min);
        }
        int res=0;
        while (min!=0){
            res+=min%10;
            min/=10;
        }
        return res%2==0?1:0;
    }
}
