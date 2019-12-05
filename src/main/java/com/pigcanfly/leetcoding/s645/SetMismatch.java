package com.pigcanfly.leetcoding.s645;

/**
 * @author tobbyquinn
 * @date 2019/10/25
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] ints = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;
        }
        int[] res = new int[2];
        for (int i = 1; i < ints.length; i++) {
            if (res[0] != 0 && res[1] != 0) {
                break;
            }
            if (ints[i] == 2) {
                res[0] = i;
            } else if (ints[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }

    /**
     * TODO xor
     * @param nums
     * @return
     */
    public int[] findErrorNums1(int[] nums) {
        int xor = 0, xor0 = 0, xor1 = 0;
        for (int n: nums)
            xor ^= n;
        for (int i = 1; i <= nums.length; i++)
            xor ^= i;
        int rightmostbit = xor & ~(xor - 1);
        for (int n: nums) {
            if ((n & rightmostbit) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightmostbit) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == xor0)
                return new int[]{xor0, xor1};
        }
        return new int[]{xor1, xor0};
    }
}
