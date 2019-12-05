package com.pigcanfly.leetcoding.s1175;

/**
 * @author tobbyquinn
 * @date 2019/10/29
 */
public class PrimeArrangements {
    public static int numPrimeArrangements(int n) {
        if (n == 1) {
            return 1;
        }
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int prime = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] <= n) {
                prime++;
            }
        }
        int nonPrime = n - prime;
        long res = 1;
        for (int i = prime; i >= 1; i--) {
            res = (res*(i%1000000007))%1000000007;
        }
        for (int i = nonPrime; i >= 1; i--) {
            res = (res*(i%1000000007))%1000000007;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int i = numPrimeArrangements(100);
        System.out.println(i);
        System.out.println(Math.pow(10,9)+7);
    }
}
