package com.pigcanfly.leetcoding.s970;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2019/10/25
 */
public class PowerfulIntegers {
    /**
     * 解题思路：bound最大边界为10^6,
     * 假设 x=1,y=1，则不论是几次方 结果都为2
     * 假设一个为1，另一个为2，则循环最大次数为 log2(10^6-1)
     * 当然 如果另一个数大于2，循环次数只能更小
     * O(N2) Time Limit Exceeded
     *
     * @param x
     * @param y
     * @param bound
     * @return
     */
    public List<Integer> powerfulIntegers1(int x, int y, int bound) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (sum <= bound) {
                    sets.add(sum);
                } else {
                    break;
                }
            }
        }
        return new ArrayList<>(sets);
    }


    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> sets = new HashSet<>();
        if (x == 1 && y == 1) {
            if (bound < 2) {
                return Collections.emptyList();
            } else {
                ArrayList res = new ArrayList<Integer>();
                res.add(2);
                return res;
            }

        }
        int min = Math.min(x, y) == 1 ? Math.max(x, y) : Math.min(x, y);
        int bn = 0;
        while (Math.pow(min, bn) <= 999999) {
            bn++;
        }
        bn++;
        for (int i = 0; i < bn; i++) {
            for (int j = 0; j < bn; j++) {
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (sum <= bound) {
                    sets.add(sum);
                } else {
                    break;
                }
            }
        }
        return new ArrayList<>(sets);
    }

    public List<Integer> powerfulIntegers2(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                s.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(s);
    }


    public static void main(String[] args) {
        List<Integer> integers = new PowerfulIntegers().powerfulIntegers(1, 2, 100000);

    }
}
