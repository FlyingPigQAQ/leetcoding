package com.pigcanfly.test;

/**
 * @author tobbyquinn
 * @date 2020/07/18
 */
public class TestException {

    public void t1() throws PException {
        throw new PException();
    }

    public void t2() throws PException {
        try {
            t1();
        } catch (final ParseException e) {
            System.out.println("Hello");
            System.out.println(e.getMessage());
            throw new PException();
        }
    }

    public static void main(String[] args) throws PException {
        new TestException().t2();
    }
}
