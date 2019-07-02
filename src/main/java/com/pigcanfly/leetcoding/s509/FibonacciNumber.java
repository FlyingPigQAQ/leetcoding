package com.pigcanfly.leetcoding.s509;

/**
 * @author Tobby Quinn
 * @date 2019/06/19
 */
public class FibonacciNumber {
    public int fib(int N) {
        if(N==0){return 0;}
        if(N==1){return 1;}
        return fib(N-1)+fib(N-2);
    }

    public static void main(String[] args) {
        FibonacciNumber obj = new FibonacciNumber();
        int fib = obj.fib(31);
        System.out.println(fib);
    }
}
