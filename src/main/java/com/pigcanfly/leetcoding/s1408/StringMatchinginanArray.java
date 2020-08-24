package com.pigcanfly.leetcoding.s1408;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/05/26
 */
public class StringMatchinginanArray {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String origin = words[i];
            for (int j = 0; j < words.length; j++) {
                String compare = words[j];
                if(origin.length()<compare.length() && compare.contains(origin)){
                    res.add(origin);
                    break;
                }
            }
        }
        return res;
    }
}
