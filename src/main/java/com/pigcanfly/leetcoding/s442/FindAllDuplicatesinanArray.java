package com.pigcanfly.leetcoding.s442;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/11/29
 */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        int left = 0;
        while (left < nums.length) {
            if (nums[left] != left + 1) {
                int curr = nums[left];
                if (nums[curr - 1] == curr) {
                    left++;
                } else {
                    nums[left] = nums[curr - 1];
                    nums[curr - 1] = curr;
                }
            } else {
                left++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
