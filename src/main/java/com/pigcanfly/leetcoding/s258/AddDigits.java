package com.pigcanfly.leetcoding.s258;

/**
 * @author tobbyquinn
 * @date 2019/09/27
 */
public class AddDigits {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        if(num%9==0){
            return 9;
        }
        return num%9;
    }
    public int addDigits1(int num) {
        if(num==0){
            return 0;
        }
        return 1+(num-1)%9;
    }

    public static void main(String[] args) {
        System.out.println(-1%9);
    }
}
