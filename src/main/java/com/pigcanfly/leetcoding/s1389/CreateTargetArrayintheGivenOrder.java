package com.pigcanfly.leetcoding.s1389;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2020/04/07
 */
public class CreateTargetArrayintheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        ArrayList<Integer> arr = new ArrayList(len);
        for (int i = 0; i < len; i++) {
            arr.add(index[i], nums[i]);
        }
        int[] target = new int[len];
        for (int i = 0; i < len; i++) {
            target[i] = arr.get(i);
        }
        return target;
    }
}
