package com.pigcanfly.leetcoding.s496;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2019/09/28
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Value,Index
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            cache.put(nums2[i],i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i <nums1.length ; i++) {
            int val = nums1[i];
            for (int j = cache.get(val); j <nums2.length ; j++) {
                if(nums2[j]>val){
                    res[i]=nums2[j];
                    break;
                }
                if(j==nums2.length-1){
                    res[i]=-1;
                }
            }
        }
        return res;
    }

    /**
     * 利用栈来一次性把nums2的存在所在的数的最右边的第一个大数算出来
     *
     *  9, 8, 7, 3, 2, 1, 6 ,5
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num:nums2){
            while(!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
