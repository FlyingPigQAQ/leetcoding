package com.pigcanfly.leetcoding.s414;

import java.util.HashMap;

/**
 * TODO : Integer first=null;
 * @author tobbyquinn
 * @date 2019/10/22
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int third = Integer.MIN_VALUE, second = Integer.MIN_VALUE, first = Integer.MIN_VALUE;
        int operTimes = 0;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int num : nums) {
            if (cache.containsKey(num)) {
                continue;
            }
            cache.put(num, 1);
            if (num == Integer.MIN_VALUE && (first == Integer.MIN_VALUE || second == Integer.MIN_VALUE || third == Integer.MIN_VALUE)) {
                operTimes++;
            }
            if (num > first) {
                third = second;
                second = first;
                first = num;
                operTimes++;
            } else if (num > second) {
                third = second;
                second = num;
                operTimes++;
            } else if (num > third) {
                third = num;
                operTimes++;
            }
        }
        return operTimes < 3 ? first : third;
    }

    public static void main(String[] args) {
        new ThirdMaximumNumber().thirdMax(new int[]{1, 2, -2147483648});
    }
}
