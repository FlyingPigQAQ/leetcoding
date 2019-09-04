package com.pigcanfly.leetcoding.s520;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tobby Quinn
 * @date 2019/08/27
 */
class DetectCapitalTest {

    private static final DetectCapital obj = new DetectCapital();

    @Test
    void detectCapitalUse() {
        assertTrue(obj.detectCapitalUse("USA"));
    }

    @Test
    void detectCapitalUse1() {
        assertFalse(obj.detectCapitalUse("FlaG"));
    }
    @Test
    void detectCapitalUse2() {
        assertTrue(obj.detectCapitalUse("Usa"));
    }
    @Test
    void detectCapitalUse3() {
        assertTrue(obj.detectCapitalUse("usa"));
    }
    @Test
    void detectCapitalUse4() {
        assertFalse(obj.detectCapitalUse("usA"));
    }
}