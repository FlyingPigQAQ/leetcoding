package com.pigcanfly.leetcoding.s1436;

import java.util.HashMap;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/05/11
 */
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            String originCity=path.get(0);
            String destCity=path.get(1);
            map.put(originCity,map.getOrDefault(originCity,0));
            map.put(destCity,map.getOrDefault(destCity,0)+1);
        }
        return map.entrySet().stream().filter(entry -> {
            return entry.getValue()==0;
        }).findFirst().get().getKey();
    }
}
