package com.pigcanfly.leetcoding.s278;

/**
 * @author tobbyquinn
 * @date 2019/10/23
 */
public class FirstBadVersion {
    /**
     * Time Limit O(N)
     *
     * @param n
     * @return
     */
    public int firstBadVersion1(int n) {
        for (int i = 0; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return 0;
    }

    public int firstBadVersion(int n) {
        int left = 0, right = n, minIndex = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
                minIndex = Math.min(mid, minIndex);
            }else{
                left=mid+1;
            }
        }
        return minIndex;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
