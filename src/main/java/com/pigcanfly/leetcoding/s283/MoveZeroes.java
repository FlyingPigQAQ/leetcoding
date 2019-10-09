package com.pigcanfly.leetcoding.s283;

/**
 * @author tobbyquinn
 * @date 2019/09/28
 */
public class MoveZeroes {
    /**
     * 根据0的次数，循环将数据移动的最后
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
            int zeros = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeros++;
                }
            }
            while (zeros > 0) {
                int swap = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (swap == -1) {
                        if (nums[i] == 0) {
                            swap = i;
                            continue;
                        }
                    } else {
                        if (nums[i] != 0) {
                            nums[swap] = nums[i];
                            nums[i] = 0;
                            swap = i;
                        }
                    }
                }
                zeros--;
            }
        }

    }

    /**
     * 将非0数字移动的非0数字后
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int lastNonZeroFoundAt=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[lastNonZeroFoundAt++]=nums[i];
            }
        }
        //填充后续0位
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i]=0;
        }
    }

}
