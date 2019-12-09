package com.pigcanfly.leetcoding.s1056;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/12/06
 */
public class ConfusingNumber {
    public boolean confusingNumber(int N) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(0,0);
        cache.put(1,1);
        cache.put(6,9);
        cache.put(8,8);
        cache.put(9,6);
        int origin=N,res = 0;
        while (N != 0) {
            int digit = N % 10;
            if (cache.containsKey(digit)) {
                res=res*10+cache.get(digit);
            }else {
                return false;
            }
            N /= 10;
        }
        return res!=origin;
    }
}
