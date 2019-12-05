package com.pigcanfly.leetcoding.s686;

/**
 * TODO 参考另一个算法 Approach #2: Rabin-Karp (Rolling Hash) [Accepted]
 * https://leetcode.com/problems/repeated-string-match/solution/
 * @author tobbyquinn
 * @date 2019/10/28
 */
public class RepeatedStringMatch {
    /**
     * O(N2) Time Limit Exceeded
     *
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch2(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int min = B.length() / A.length();
        for (int i = 0; i < min; i++) {
            sb.append(A);
            if (sb.toString().contains(B)) {
                return min;
            }
        }
        for (int j = 1; j <= 3; j++) {
            sb.append(A);
            if (sb.toString().contains(B)) {
                return j + min;
            }
        }
        return -1;
    }

    public static int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int q = 1;
        for (; sb.length() < B.length(); q++) {
            sb.append(A);
        }
        if (sb.toString().contains(B)) {
            return q-1;
        }
        if(sb.append(A).toString().contains(B)){
            return q;
        }
        return -1;
    }
    public static int repeatedStringMatch1(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }

    public static void main(String[] args) {
        repeatedStringMatch("abc","cabcabca");
    }

}
