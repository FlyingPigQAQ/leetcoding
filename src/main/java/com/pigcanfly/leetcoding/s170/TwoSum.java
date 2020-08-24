package com.pigcanfly.leetcoding.s170;

import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2020/04/30
 */
public class TwoSum {
    HashSet<Integer> originSets = null;
    HashSet<Integer> sumSets = null;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        originSets = new HashSet<>();
        sumSets = new HashSet<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        originSets.stream().forEach(x -> sumSets.add(x + number));
        originSets.add(number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        return sumSets.contains(value);
    }
}
