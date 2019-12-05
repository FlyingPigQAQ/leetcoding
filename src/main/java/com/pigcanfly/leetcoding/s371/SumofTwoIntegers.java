package com.pigcanfly.leetcoding.s371;

/**
 * @author tobbyquinn
 * @date 2019/11/22
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
      while(b!=0){
          int at =a^b;
          b=a&b; //进位数
          b<<=1;
          a=at;
      }
      return a^b;
    }

    public static void main(String[] args) {
        int sum = new SumofTwoIntegers().getSum(-2, 3);
        System.out.println(sum);
    }
}
