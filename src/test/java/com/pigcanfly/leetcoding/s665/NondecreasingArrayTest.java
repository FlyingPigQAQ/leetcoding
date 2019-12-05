package com.pigcanfly.leetcoding.s665;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tobbyquinn
 * @date 2019/10/25
 */
class NondecreasingArrayTest {
    NondecreasingArray obj = new NondecreasingArray();

    @Test
    void checkPossibility() {
        Assert.assertTrue(obj.checkPossibility(new int[]{4, 2, 3}));
    }
    @Test
    void checkPossibility1() {
        Assert.assertFalse(obj.checkPossibility(new int[]{4, 2, 1}));
    }
    @Test
    void checkPossibility2() {
        Assert.assertFalse(obj.checkPossibility(new int[]{3, 4, 2,3}));
    }
    @Test
    void checkPossibility3() {
        Assert.assertFalse(obj.checkPossibility(new int[]{3, 3, 2,2}));
    }
}