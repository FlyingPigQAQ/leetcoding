package com.pigcanfly.leetcoding.s1295;

/**
 * @author tobbyquinn
 * @date 2019/12/23
 */
public class FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int tmp = 0;
            while (num != 0) {
                tmp++;
                num /= 10;
            }
            if (tmp != 0 && tmp % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
