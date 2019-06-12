package com.pigcanfly.leetcoding.s238;

import com.pigcanfly.leetcoding.utils.PrintUtil;

/**
 * @author Tobby Quinn
 * @date 2019/06/11
 */
public class ProductOfArrayExceptSelf {
    /**
     * 左积*右积 就是除了本身以外，其他元素的乘积
     * 时间复杂度为O(N) 常数项为3
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        if(nums.length==1){
            return nums;
        }
        int[] left = new int[nums.length];
        //左积
        for (int i = 0; i < nums.length; i++) {
           left[i]= i==0?nums[i]:(left[i-1]*nums[i]);
        }

        int[] right = new int[nums.length];
        //右积
        for (int j = nums.length-1;  j>=0; j--) {
            right[j]= j==nums.length-1?nums[j]:(right[j+1]*nums[j]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                res[i]=right[i+1];
            }else if(i==nums.length-1){
                res[i]=left[i-1];
            }else{
                res[i]=right[i+1]*left[i-1];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1, 2, 3, 4});
        PrintUtil.iteratorInteger(ints);

    }
}
