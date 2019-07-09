package com.pigcanfly.leetcoding.s1002;

import java.util.*;

/**
 * @author Tobby Quinn
 * @date 2019/07/04
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            String a = A[i];
            for (int j = 0; j < a.length(); j++) {
                char c = a.charAt(j);
                if (map.containsKey(c)) {
                    int[] ints = map.get(c);
                    ints[i] += 1;
                    map.put(c, ints);
                    continue;
                }
                if (i == 0) {
                    int[] ints = new int[A.length];
                    ints[0] = 1;
                    map.put(c, ints);
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        Set<Map.Entry<Character, int[]>> entries = map.entrySet();
        entries.stream().filter(entry -> entry.getValue()[entry.getValue().length-1]!= 0).forEach(e -> {
            Arrays.sort(e.getValue());
            for (int j = 0; j < e.getValue()[0]; j++) {
                res.add(e.getKey().toString());
            }
        });
        return res;

    }


}


