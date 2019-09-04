package com.pigcanfly.leetcoding.s888;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tobby Quinn
 * @date 2019/08/27
 */
class FairCandySwapTest {
    private static final  FairCandySwap obj = new FairCandySwap();
    @Test
    void fairCandySwap() {
        int[] a = {1, 1};
        int[] b = {2, 2};
        int[] res = obj.fairCandySwap(a, b);
        assertArrayEquals(new int[]{1,2},res);
    }
    @Test
    void fairCandySwap1() {
        int[] a = {1, 2};
        int[] b = {2, 3};
        int[] res = obj.fairCandySwap(a, b);
        assertArrayEquals(new int[]{1,2},res);
    }
    @Test
    void fairCandySwap2() {
        int[] a = { 2};
        int[] b = {1, 3};
        int[] res = obj.fairCandySwap(a, b);
        assertArrayEquals(new int[]{2,3},res);
    }
    @Test
    void fairCandySwap3() {
        int[] a = {1, 2,5};
        int[] b = {2, 4};
        int[] res = obj.fairCandySwap(a, b);
        assertArrayEquals(new int[]{5,4},res);
    }
}