package com.pigcanfly.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tobbyquinn
 * @date 2019/09/04
 */
class InsertionSortTest {

    @Test
    void sort0() {
        int[] inits = new int[0];
        InsertionSort.sort(inits);
        for (int i = 0; i < inits.length; i++) {
            System.out.print(inits[i]+",");
        }
        assertArrayEquals(new int[0], inits);
    }

    @Test
    void sort1() {
        int[] inits = new int[]{10};
        InsertionSort.sort(inits);
        for (int i = 0; i < inits.length; i++) {
            System.out.print(inits[i]+",");
        }
        assertArrayEquals(new int[]{10}, inits);
    }

    @Test
    void sort2() {
        int[] inits = new int[]{1, 5, 8, 11, 2, 7};
        InsertionSort.sort(inits);
        for (int i = 0; i < inits.length; i++) {
            System.out.print(inits[i] + ",");
        }
        assertArrayEquals(new int[]{1, 2, 5, 7, 8, 11}, inits);
    }

    @Test
    void sort3() {
        int[] inits = new int[]{1, 2, 2, 2, 5, 8, 11, 2, 7};
        InsertionSort.sort(inits);
        for (int i = 0; i < inits.length; i++) {
            System.out.print(inits[i] + ",");
        }
        assertArrayEquals(new int[]{1, 2, 2, 2, 2, 5, 7, 8, 11}, inits);
    }
}