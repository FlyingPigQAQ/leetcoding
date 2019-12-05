package com.pigcanfly.leetcoding.s266;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/12/04
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = cache.getOrDefault(c, 0);
            cache.put(c,val+1);
        }
        long odd = cache.values().stream().filter(x -> x % 2 != 0).count();
        return odd<2;
    }

    public boolean canPermutePalindrome1(String s) {
        int count = 0;
        for (char i = 0; i < 128 && count <= 1; i++) {
            int ct = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i)
                    ct++;
            }
            count += ct % 2;
        }
        return count <= 1;
    }


}
