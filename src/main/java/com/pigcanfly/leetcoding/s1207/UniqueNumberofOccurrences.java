package com.pigcanfly.leetcoding.s1207;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2019/10/18
 */
public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        HashSet<Integer> counts = new HashSet<>();
        for (int i : arr) {
            cache.put(i,cache.getOrDefault(i,0)+1);
        }
        for (Integer value : cache.values()) {
            if(counts.contains(value)){
                return false;
            }
            counts.add(value);
        }
        return true;
    }
}
