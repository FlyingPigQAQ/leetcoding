package com.pigcanfly.leetcoding.s721;

import akka.actor.FSM;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2020/06/05
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<HashSet<String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            if(!map.containsKey(name)){
                map.put(name,new ArrayList<HashSet<String>>());
            }
            HashSet<String> sets = new HashSet<>();
            for (int i = 1; i < account.size(); i++) {
                sets.add(account.get(i));
            }
            map.get(name).add(sets);
        }
        //merge
        map.forEach((k,v)->{
            Iterator<HashSet<String>> iterator = v.iterator();
            while (iterator.hasNext()){
                HashSet<String> set = iterator.next();
                Iterator<String> iterator1 = set.iterator();
                while (iterator1.hasNext()){
                    String email = iterator1.next();

                }
            }
        });
        return null;
    }

}
