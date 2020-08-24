package com.pigcanfly.leetcoding.s1342;

/**
 * @author tobbyquinn
 * @date 2020/02/12
 */
public class NumberofStepstoReduceaNumbertoZero {
    public int numberOfSteps1(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            res++;
        }
        return res;
    }

    public int numberOfSteps(int num) {
        //leftmost 1
        int res = -1;
        while (num != 0) {
            if((num&1)==0){
                res++;
            }else{
                res+=2;
            }
            num>>=1;
        }
        return Math.max(res,0);
    }
}
