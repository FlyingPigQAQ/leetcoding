package com.pigcanfly.leetcoding.s1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/01/09
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> cache = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            ArrayList<Integer> arr = cache.getOrDefault(groupSize, new ArrayList<>());
            arr.add(i);
            if(arr.size()== groupSize){
                res.add(arr);
                cache.remove(groupSize);
            }else {
                cache.put(groupSize,arr);
            }
        }
        return res;
    }


}
