package com.pigcanfly.leetcoding.s1180;

import java.util.Comparator;
import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/11/28
 */
public class CountSubstringswithOnlyOneDistinctLetter {
    public int countLetters(String S) {
        HashMap<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            for (int j = i+1; j <= S.length(); j++) {
                String substring = S.substring(i, j);
               if(cache.containsKey(substring)){
                   cache.put(substring,cache.get(substring)+1);
               } else {
                   if(isDistinctLetter(substring)){
                       cache.put(substring,1);
                   }else{
                       break;
                   }
               }
            }
        }
        return cache.values().stream().mapToInt(Integer::intValue).sum();
    }

    boolean isDistinctLetter(String s) {
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }

    /**
     *  a  1       1*2/2
     *  aa 3       2*3/2
     *  aaa 6      3*4/2
     *  aaaa 10    4*5/2
     *  a... n     n*(n+1)/2
     * @param S
     * @return
     */
    public int countLetters1(String S) {
        int ans = 0, repeat = 1;
        for (int i = 1; i < S.length(); ++i, ++repeat) {
            if (S.charAt(i) != S.charAt(i - 1)) { // previous char consectively occurs 'repeat' times.
                ans += repeat * (repeat + 1) / 2;
                repeat = 0;
            }
        }
        return ans + repeat * (repeat + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(2,3));
    }
}
