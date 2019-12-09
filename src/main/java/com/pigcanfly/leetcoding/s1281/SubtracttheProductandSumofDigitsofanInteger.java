package com.pigcanfly.leetcoding.s1281;

/**
 * @author tobbyquinn
 * @date 2019/12/09
 */
public class SubtracttheProductandSumofDigitsofanInteger {
    public int subtractProductAndSum(int n) {
        int product=1,sum=0;
        while(n!=0){
            int tmp=n%10;
            product*=tmp;
            sum+=tmp;
            n/=10;
        }
        return product-sum;
    }
}
