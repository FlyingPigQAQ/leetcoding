package com.pigcanfly.leetcoding.s1134;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class ArmstrongNumber {
    public boolean isArmstrong(int N) {
        int k=String.valueOf(N).length(),sum=0,n=N;
        while (n!=0){
            int mod=n%10;
            sum+=Math.pow(mod,k);
            n/=10;
        }
        return sum==N;
    }

    public static void main(String[] args) {
        boolean armstrong = new ArmstrongNumber().isArmstrong(153);
        System.out.println(armstrong);
    }
}
