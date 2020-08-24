package com.pigcanfly.leetcoding.s1380;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * Example 2:
 *
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 *
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 * @author tobbyquinn
 * @date 2020/04/28
 */
public class LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        HashSet<Integer> set = new HashSet();
        for (int[] arr : matrix) {
            int minimum = Integer.MAX_VALUE;
            for (int a : arr) {
                minimum = Math.min(a, minimum);
            }
            set.add(minimum);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int maximum = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                maximum = Math.max(maximum, matrix[j][i]);
            }
            if (set.contains(maximum)) {
                res.add(maximum);
            }
        }
        return res;
    }
}
