package com.pigcanfly.leetcoding.s49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tobbyquinn
 * @date 2020/06/11
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] cache = new int[26];
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                cache[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(cache[i]!=0){
                    sb.append((char)(i+'a'));
                    sb.append(cache[i]);
                }
            }
            List<String> arr = map.getOrDefault(sb.toString(),new ArrayList<String>());
            arr.add(str);
            map.put(sb.toString(),arr);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

}
