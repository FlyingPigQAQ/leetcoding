package com.pigcanfly.leetcoding.s204;

/**
 * TODO:查找更优解决方案266. Palindrome Permutation
 * @author tobbyquinn
 * @date 2019/12/03
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int res = 1;
        for (int i = 3; i < n; i += 2) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }

    boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new CountPrimes().countPrimes(10);
    }
}
