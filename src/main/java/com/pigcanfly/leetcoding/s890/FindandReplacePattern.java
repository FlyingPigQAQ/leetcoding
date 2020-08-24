package com.pigcanfly.leetcoding.s890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tobbyquinn
 * @date 2020/07/20
 */
public class FindandReplacePattern {
    public List<String> findAndReplacePatternByOwn(String[] words, String pattern) {
        Map<Character, Character> wordMap;
        Map<Character, Character> patternMap;
        List<String> res = new ArrayList<>();
        here:
        for (String word : words) {
            if (pattern.length() != word.length()) {
                continue;
            }
            wordMap = new HashMap<>();
            patternMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                char p = pattern.charAt(i);
                if (wordMap.containsKey(c) && wordMap.get(c) != pattern.charAt(i)) {
                    continue here;
                }
                if (patternMap.containsKey(p) && patternMap.get(p) != c) {
                    continue here;
                }
                wordMap.put(c, p);
                patternMap.put(p, c);
            }
            res.add(word);
        }
        return res;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> wordMap = new HashMap<>();
        Map<Character, Character> patternMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char p = pattern.charAt(i);
            if (!wordMap.containsKey(c)) {
                wordMap.put(c, p);
            }
            if (!patternMap.containsKey(p)) {
                patternMap.put(p, c);
            }
            if (wordMap.get(c) != p || patternMap.get(p) != c) {
                return false;
            }
        }
        return true;
    }
}
