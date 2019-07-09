package com.pigcanfly.leetcoding.utils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class TestPriorityQueue {

    public static void main(String[] args) {
        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o1 < o2 ? 1 : o1.equals(o2) ? 0 : -1);

        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(0);
        Integer poll = maxHeap.poll();
        System.out.println(poll);
    }
}
