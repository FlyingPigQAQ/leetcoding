package com.pigcanfly.leetcoding.s346;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tobbyquinn
 * @date 2019/11/28
 */
public class MovingAverage {
    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> queue;
    private int maxWindowSize;
    private double total = 0;
    private int moveTimes = 0;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.maxWindowSize = size;
    }

    public double next(int val) {
        moveTimes++;
        queue.add(val);
        total += val;
        if (moveTimes <= maxWindowSize) {
            return total / moveTimes;
        }
        Integer first = queue.poll();
        total -= first;
        return total / maxWindowSize;
    }
}
