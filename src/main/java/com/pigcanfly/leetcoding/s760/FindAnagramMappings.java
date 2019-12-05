package com.pigcanfly.leetcoding.s760;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            cache.put(B[i],i);
        }
        for (int i = 0; i < A.length; i++) {
            A[i]=cache.get(A[i]);
        }
        return A;
    }
}
