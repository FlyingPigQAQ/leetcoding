package com.pigcanfly.leetcoding.s170;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2020/04/30
 */
public class TwoSum1 {
    HashMap<Integer, Integer> origin = null;

    /**
     * Initialize your data structure here.
     */
    public TwoSum1() {
        origin = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        origin.put(number, origin.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {

        for (Integer num : origin.keySet()) {
            int diff = value - num;
            if (origin.containsKey(diff)) {
                if(diff!=num){
                    return true;
                }else if ( origin.get(num) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
