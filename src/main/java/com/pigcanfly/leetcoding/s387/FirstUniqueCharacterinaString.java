package com.pigcanfly.leetcoding.s387;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/11
 */
public class FirstUniqueCharacterinaString {

    public int firstUniqChar1(String s) {
        HashMap<Character,Integer> unique = new HashMap();
        HashMap<Character,Integer> dummp = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(dummp.containsKey(c)){
                continue;
            }
            if(unique.containsKey(c)){
                unique.remove(c);
                dummp.put(c,1);
                continue;
            }
            unique.put(c,i);
        }
        if(unique.size()==0){
            return -1;
        }
        int min=Integer.MAX_VALUE;
        java.util.Collection<Integer> values = unique.values();
        for (Integer i:values){
            min=Math.min(min,i);
        }
        return min;
    }
    public int firstUniqChar(String s) {
        int[] cache = new int[26];
        int len=s.length();
        for (int i = 0; i < len; i++) {
            cache[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < len; i++) {
            if(cache[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
