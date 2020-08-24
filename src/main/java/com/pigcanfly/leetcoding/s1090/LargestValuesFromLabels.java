package com.pigcanfly.leetcoding.s1090;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author tobbyquinn
 * @date 2020/01/31
 */
public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < labels.length; i++) {
            //value,key
            q.add(new int[]{values[i], labels[i]});
        }
        //label,limits
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0,wanted=0;
        while (!q.isEmpty()){
            if(wanted>=num_wanted){
                break;
            }
            int[] poll = q.poll();
            int value = 0;
            if ((value = map.getOrDefault(poll[1], 0)) < use_limit) {
                sum += poll[0];
                map.put(poll[1], value + 1);
                wanted++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = new LargestValuesFromLabels().largestValsFromLabels(new int[]{2, 1, 5, 2, 8}, new int[]{2, 0, 2, 2, 2},
                3, 2);
        System.out.println(i);
    }
}
