package com.pigcanfly.leetcoding.s819;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2019/10/11
 */
public class MostCommonWord {
    public String mostCommonWord1(String paragraph, String[] banned) {
        HashMap<String, Integer> banDict = new HashMap<>();
        for (int i = 0; i < banned.length; i++) {
            banDict.put(banned[i],1);
        }
        String[] words = paragraph.toLowerCase().split("[!|\\?|'|,|;|.| ]");
        HashMap<String, Integer> wordsCache = new HashMap<>();
        for (String word : words) {
            if(banDict.containsKey(word) || word.equals("")){
                continue;
            }
            if(wordsCache.containsKey(word)){
                wordsCache.put(word,wordsCache.get(word)+1);
                continue;
            }
            wordsCache.put(word,1);
        }
        int max=Integer.MIN_VALUE;
        String key="";
        Set<Map.Entry<String, Integer>> entries = wordsCache.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue()>max){
                max=entry.getValue();
                key=entry.getKey();
            }
        }
        return key;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banDict = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.toLowerCase().split("[!|\\?|'|,|;|.| ]");
        HashMap<String, Integer> wordsCache = new HashMap<>();
        for (String word : words) {
            if (!banDict.contains(word) && !word.equals("")) {
                wordsCache.put(word, wordsCache.getOrDefault(word, 1) + 1);
            }
        }
        //TODO: 看源码
        return Collections.max(wordsCache.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String s="Bob. hIt, baLl";
        new MostCommonWord().mostCommonWord(s,new String[]{
                "bob", "hit"});
    }
}
