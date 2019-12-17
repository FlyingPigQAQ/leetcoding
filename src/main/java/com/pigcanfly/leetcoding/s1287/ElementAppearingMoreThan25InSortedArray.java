package com.pigcanfly.leetcoding.s1287;

/**
 * TODO 考虑数组越界 细心更细心
 * @author tobbyquinn
 * @date 2019/12/16
 */
public class ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        for (int mid : new int[]{arr.length / 2, arr.length / 4, arr.length * 3 / 4}) {
            int left = mid, right = mid, num = arr[mid];
            while (left >= 0 && right <= arr.length - 1 && (arr[left] == num || arr[right] == num)) {
                if (arr[left] == num) {
                    left--;
                }
                if (arr[right] == num) {
                    right++;
                }
            }
            if ((right - left - 1) >= arr.length / 4) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new ElementAppearingMoreThan25InSortedArray().findSpecialInteger(arg));
    }
}
