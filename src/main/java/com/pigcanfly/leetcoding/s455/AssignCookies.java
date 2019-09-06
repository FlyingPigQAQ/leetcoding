package com.pigcanfly.leetcoding.s455;

import java.util.Arrays;

/**
 * @author tobbyquinn
 * @date 2019/09/05
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) {
            return 0;
        }
        Arrays.sort(s);
        Arrays.sort(g);
        int sLen = s.length, sIndex = sLen - 1, gLen = g.length,
                gIndex = gLen - 1, max = 0;
        while (gIndex >= 0 && sIndex >= 0) {
            if (s[sIndex] >= g[gIndex]) {
                max++;
                sIndex--;
            }
            gIndex--;
        }
        return max;
    }
}
