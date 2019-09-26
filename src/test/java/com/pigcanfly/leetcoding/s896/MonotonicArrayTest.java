package com.pigcanfly.leetcoding.s896;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.pigcanfly.leetcoding.s896.MonotonicArray.*;

/**
 * @author tobbyquinn
 * @date 2019/09/12
 */
class MonotonicArrayTest {

    @Test
    void isMonotonic1() {
        boolean monotonic = isMonotonic(new int[]{1, 2, 2, 3});
        assertTrue(monotonic);
    }

    @Test
    void isMonotonic2() {
        boolean monotonic = isMonotonic(new int[]{6, 5, 4, 4});
        assertTrue(monotonic);
    }
    @Test
    void isMonotonic3() {
        boolean monotonic = isMonotonic(new int[]{1, 3,2});
        assertFalse(monotonic);
    }
    @Test
    void isMonotonic4() {
        boolean monotonic = isMonotonic(new int[]{1, 2,4,5});
        assertTrue(monotonic);
    }
    @Test
    void isMonotonic5() {
        boolean monotonic = isMonotonic(new int[]{1, 1,1});
        assertTrue(monotonic);
    }
}