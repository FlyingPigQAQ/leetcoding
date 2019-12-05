package com.pigcanfly.leetcoding.s575;

import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2019/11/23
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int half = candies.length/2;
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), half);
    }
}
