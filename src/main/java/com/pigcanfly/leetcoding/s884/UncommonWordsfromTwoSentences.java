package com.pigcanfly.leetcoding.s884;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/09/03
 */
public class UncommonWordsfromTwoSentences {
    public static String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] aSplits = A.split(" "), bSplits = B.split(" ");
        int index = 0, aLen = aSplits.length, bLen = bSplits.length;
        while (index < aLen || index < bLen) {
            if (index < aLen) {
                String aSplit = aSplits[index];
                if (map.containsKey(aSplit)) {
                    map.put(aSplit, map.get(aSplit) + 1);
                } else {
                    map.put(aSplit, 1);
                }
            }
            if (index < bLen) {
                String bSplit = bSplits[index];
                if (map.containsKey(bSplit)) {
                    map.put(bSplit, map.get(bSplit) + 1);
                } else {
                    map.put(bSplit, 1);
                }
            }
            index++;
        }
        return map.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] strings = uncommonFromSentences("this apple is sweet",
                "this apple is sour");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
