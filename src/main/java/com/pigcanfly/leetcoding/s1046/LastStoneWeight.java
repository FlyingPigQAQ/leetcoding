package com.pigcanfly.leetcoding.s1046;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        //最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o1 < o2 ? 1 : o1.equals(o2) ? 0 : -1);
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size()>1){
            Integer big = maxHeap.poll();
            Integer small = maxHeap.poll();
            if(!big.equals(small)){
                maxHeap.add(big-small);
            }
        }
        return maxHeap.size()==0?0:maxHeap.poll();

    }
}
