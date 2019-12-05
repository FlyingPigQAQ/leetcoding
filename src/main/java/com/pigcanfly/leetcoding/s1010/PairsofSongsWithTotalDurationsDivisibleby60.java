package com.pigcanfly.leetcoding.s1010;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/24
 */
public class PairsofSongsWithTotalDurationsDivisibleby60 {
    /**
     * O(N2) Time Limit Exceeded
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy601(int[] time) {
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        HashMap<Integer, ArrayList<Integer>> cache = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            if (cache.containsKey(time[i])) {
                ArrayList<Integer> arrs = cache.get(time[i]);
                for (int i1 = 0; i1 < arrs.size(); i1++) {
                    if (i < arrs.get(i1)) {
                        res += arrs.size() - i1;
                        break;
                    }
                }
            } else {
                for (int j = i + 1; j < time.length; j++) {
                    if ((time[i] + time[j]) % 60 == 0) {
                        if (!cache.containsKey(time[i])) {
                            ArrayList<Integer> arrs = new ArrayList<>();
                            cache.put(time[i], arrs);
                        }
                        cache.get(time[i]).add(j);
                        res++;
                    }
                }
            }

        }
        return res;
    }
    public int numPairsDivisibleBy602(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            res += c[(600 - t) % 60];
            c[t % 60] += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{30,20,150,100,40};
        new PairsofSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy602(ints);
    }

}
