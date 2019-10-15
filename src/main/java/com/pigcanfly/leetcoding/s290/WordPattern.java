package com.pigcanfly.leetcoding.s290;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/14
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if(pattern.length()!=s.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String,Character> map1 = new HashMap<>();
        int index=0;
        for (String s1 : s) {
            char p = pattern.charAt(index++);
            if(map.containsKey(p) || map1.containsKey(s1)){
                if(map.get(p)==null || map1.get(s1)==null || !map.get(p).equals(s1) || map1.get(s1)!=p){
                    return false;
                }
            }else {
                map.put(p,s1);
                map1.put(s1,p);
            }
        }
        return true;
    }
}
