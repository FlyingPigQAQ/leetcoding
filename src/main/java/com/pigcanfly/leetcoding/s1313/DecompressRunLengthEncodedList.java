package com.pigcanfly.leetcoding.s1313;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author tobbyquinn
 * @date 2020/01/15
 */
public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= nums.length-2; i+=2) {
            for (int j = 0; j < nums[i]; j++) {
                res.add(nums[i+1]);
            }
        }
       return  res.stream().mapToInt(Integer::intValue).toArray();
    }
}
