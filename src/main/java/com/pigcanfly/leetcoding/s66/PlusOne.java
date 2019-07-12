package com.pigcanfly.leetcoding.s66;

/**
 * @author Tobby Quinn
 * @date 2019/07/11
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n=digits.length;
        int[] nums = new int[n + 1];
        int carry=0;
        for (int i = n-1; i >=0 ; i--) {
            int res;
            if(i==n-1){
                res=digits[i]+1+carry;
            }else{
                res=digits[i]+carry;
            }
            if(res>9){
                carry=1;
                res-=10;
            }else {
                carry=0;
            }
            nums[i+1]=res;
            digits[i]=res;
        }
        if(carry==0){
            return digits;
        }else {
            nums[0]=1;
            return nums;
        }
    }
    //TODO 更简单的算法
    public static int[] plusOne1(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        plusOne1(new int[]{9,9,9});
    }
}
