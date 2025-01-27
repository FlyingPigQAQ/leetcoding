package com.pigcanfly.leetcoding.s836;

/**
 * @author tobbyquinn
 * @date 2019/12/02
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if ((rec1[2] <= rec2[0] || rec1[3] <= rec2[1])
                || (rec2[2] <= rec1[0] || rec2[3] <= rec1[1])) {
            return false;
        }
        return true;
    }
}
