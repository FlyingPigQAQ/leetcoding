package com.pigcanfly.leetcoding.s1;

import java.util.HashMap;

/**
 * @author Tobby Quinn
 * @date 2019/06/10
 */
public class TwoSum {
    /**
     * 时间复杂度O(N²)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, int[]> res = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                int temp = nums[i] + nums[j + 1];
                res.put(temp, new int[]{i, j + 1});
            }
        }
        return res.containsKey(target) ? res.get(target) : new int[]{};

    }

    /**
     * O(N) 常数项为2
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            res.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(target - nums[i]) && res.get(target - nums[i]) != i) {
                return new int[]{i, res.get(target - nums[i])};
            }
        }
        return new int[]{};

    }

    /**
     * O(N) 常数项为1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(target - nums[i])) {
                return new int[]{res.get(target - nums[i]), i};
            }
            res.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int[] ints = twoSum3(nums, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
