package com.pigcanfly.leetcoding.s1441;

import java.util.ArrayList;
import java.util.List;

/**
 * target严格递增(不存在相等情况)
 * @author tobbyquinn
 * @date 2020/05/21
 */
public class BuildanArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int lastStart = 1;
        for (int t : target) {
            for (int i = lastStart; i < t; i++) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
            lastStart = t + 1;
        }
        return res;

    }
}
