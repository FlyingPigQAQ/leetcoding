package com.pigcanfly.lintcode;

/**
 * @author Tobby Quinn
 * @date 2019/06/26
 */
public class Test {

    public static  int aplusb(int a,int b){
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }

    public static void main(String[] args) {
        aplusb(-1,-2);
    }
}
