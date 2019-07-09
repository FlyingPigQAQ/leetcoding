package com.pigcanfly.leetcoding.s811;

import java.util.*;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String domain:cpdomains){
            String[] s = domain.split(" ");
            Integer time = Integer.valueOf(s[0]);
            String[] subDomains = s[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = subDomains.length-1; i >=0; i--) {
                sb.insert(0,subDomains[i]);
                if(map.containsKey(sb.toString())){
                    Integer val = map.get(sb.toString());
                    map.put(sb.toString(),val+time);
                }else {
                    map.put(sb.toString(), time);
                }
                sb.insert(0,".");
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        ArrayList<String> res = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            res.add(entry.getValue()+" "+entry.getKey());
        }
        return res;
    }
}
