package com.pigcanfly.leetcoding.s697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Tobby Quinn
 * @date 2019/06/11
 */
public class DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                ArrayList<Integer> tmp = cache.get(nums[i]);
                tmp.add(i);
                cache.put(nums[i], tmp);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                cache.put(nums[i], arr);
            }
        }
        ArrayList<Integer> maxKey = new ArrayList<>();
        int maxTimes = -1;
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, ArrayList<Integer>> entry = iterator.next();
            if (entry.getValue().size() > maxTimes) {
                maxKey = new ArrayList<>();
                maxKey.add(entry.getKey());
                maxTimes = entry.getValue().size();
            }
            if (entry.getValue().size() == maxTimes) {
                maxKey.add(entry.getKey());
            }

        }
        int shortArray = Integer.MAX_VALUE;
        for (int i = 0; i < maxKey.size(); i++) {
            ArrayList<Integer> arr = cache.get(maxKey.get(i));
            Integer maxIndex = arr.get(arr.size() - 1);
            Integer minIndex = arr.get(0);
            int st = maxIndex - minIndex + 1;
            if (st < shortArray) {
                shortArray = st;
            }

        }
        return shortArray;

    }

    public static void main(String[] args) {
        int shortestSubArray = findShortestSubArray(new int[]{0});
        System.out.println(shortestSubArray);
    }
}
