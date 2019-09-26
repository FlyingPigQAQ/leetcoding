package com.pigcanfly.leetcoding.s242;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/09/18
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int sLen=s.length(),tLen=t.length();
        if(sLen!=tLen){
            return false;
        }
        int[] cache = new int[26];
        for (int i = 0; i < sLen; i++) {
            int id=s.charAt(i)-'a';
            cache[id]++;
        }
        for (int i = 0; i < tLen; i++) {
            int id=t.charAt(i)-'a';
            cache[id]--;
            if(cache[id]<0){
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(cache[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("anagram","nagaram");
    }
}
