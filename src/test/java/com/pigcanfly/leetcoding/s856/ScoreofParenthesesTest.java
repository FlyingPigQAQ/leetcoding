package com.pigcanfly.leetcoding.s856;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tobbyquinn
 * @date 2020/01/16
 */
class ScoreofParenthesesTest {


    ScoreofParentheses obj =  new ScoreofParentheses();

    @Test
    void scoreOfParentheses1() {
        int res = obj.scoreOfParentheses("()");
        Assert.assertEquals(1,res);
    }
    @Test
    void scoreOfParentheses2() {
        int res = obj.scoreOfParentheses("(())");
        Assert.assertEquals(2,res);
    }
    @Test
    void scoreOfParentheses3() {
        int res = obj.scoreOfParentheses("()()");
        Assert.assertEquals(2,res);
    }
    @Test
    void scoreOfParentheses4() {
        int res = obj.scoreOfParentheses("(()(()))");
        Assert.assertEquals(6,res);
    }
}