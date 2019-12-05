package com.pigcanfly.leetcoding.s1165;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            cache.put(keyboard.charAt(i),i);
        }
        int res=0;
        for (int i = 1; i < word.length(); i++) {
            int diff = cache.get(word.charAt(i)) - cache.get(word.charAt(i - 1));
            res+=Math.abs(diff);
        }
        return word.length()==0?res:res+cache.get(word.charAt(0));
    }
}
