package com.pigcanfly.leetcoding.s540;

/**
 * TODO:①根据单个数组出现的子串是奇数判断移动方向 ②根据单个数只能出现在第一个偶数位；只检索第一个偶数位，若与其后的数不同
 * TODO：则证明在数组左方，插入了单个数，否则遍历右边数组
 * @author tobbyquinn
 * @date 2019/12/26
 */
public class SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length - 1);
    }

    Integer singleNonDuplicate(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        if (mid == 0) {
            if (nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else {
                return null;
            }

        } else if (mid == nums.length - 1) {
            if (nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else {
                return null;
            }
        } else if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
            return nums[mid];
        } else {
            Integer r1 = singleNonDuplicate(nums, left, mid - 1);
            if(r1!=null){
                return r1;
            }
            Integer r2 = singleNonDuplicate(nums, mid + 1, right);
            if(r2!=null){
                return r2;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new SingleElementinaSortedArray().singleNonDuplicate(new int[]{1}));
    }
}



