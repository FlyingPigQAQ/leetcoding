package com.pigcanfly.leetcoding.s1160;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/09/02
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters1(String[] words, String chars) {
        int sum = 0;
        //initial cache
        HashMap<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (cache.containsKey(c)) {
                cache.put(c, cache.get(c) + 1);
            } else {
                cache.put(c, 1);
            }
        }
        for (String word : words) {
            HashMap<Character, Integer> tmp = new HashMap<>(cache);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!tmp.containsKey(c)) {
                    break;
                }
                if (tmp.get(c) == 1) {
                    tmp.remove(c);
                } else {
                    tmp.put(c, tmp.get(c) - 1);
                }
                if(i==word.length()-1){
                    sum+=word.length();
                    cache=tmp;
                }
            }
        }
        return sum;
    }
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        //initial cache
        int[] cache = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            cache[c-'a']++;
        }
        outer:for (String word:words){
            int[] clone = cache.clone();
            for (int i = 0; i <word.length() ; i++) {
                char c = word.charAt(i);
                if(--clone[c-'a']<0){
                    continue outer;
                }
            }
            sum+=word.length();
        }
        return sum;
    }
}
