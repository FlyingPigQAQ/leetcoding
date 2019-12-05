package com.pigcanfly.leetcoding.s1013;

import java.util.stream.IntStream;

/**
 * @author tobbyquinn
 * @date 2019/10/16
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum1(int[] A) {
        int total = 0;
        for (int i : A) {
            total += i;
        }
        if (total % 3 != 0) {
            return false;
        }
        int average = total / 3, left = 0, right = A.length - 1, leftSum = 0, rightSum = 0;
        while (left < right) {
            if (leftSum != average) {
                leftSum += A[left];
                left++;
            }
            if (rightSum != average) {
                rightSum += A[right];
                right--;
            }
            int remaind = total - leftSum - rightSum;
            if (leftSum == average && rightSum == average && remaind == average) {
                return true;
            }
            if (leftSum == average && rightSum == average && remaind != average) {
                return false;
            }
        }
        return false;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int total = IntStream.of(A).sum();
        if (total % 3 != 0) {
            return false;
        }
        int average = total / 3, left = 0, right = A.length - 1, leftSum = 0, rightSum = 0;
        while (left < right) {
            if (leftSum != average) {
                leftSum += A[left];
                left++;
            }
            if (rightSum != average) {
                rightSum += A[right];
                right--;
            }
            int remaind = total - leftSum - rightSum;
            if (leftSum == average && rightSum == average && remaind == average) {
                return true;
            }
            if (leftSum == average && rightSum == average && remaind != average) {
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] ints = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        boolean b = new PartitionArrayIntoThreePartsWithEqualSum().canThreePartsEqualSum(ints);
        System.out.println(b);
    }
}
