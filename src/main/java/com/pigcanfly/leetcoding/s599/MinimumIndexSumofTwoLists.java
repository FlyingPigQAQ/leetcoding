package com.pigcanfly.leetcoding.s599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/10/19
 */
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int temp = i + map.get(list2[i]);
                if (min == temp) {
                    res.add(list2[i]);
                } else if (min > temp) {
                    min = temp;
                    res.clear();
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
