package com.pigcanfly.design.pattern.strategy;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class Operator {
    public void exec(String operatorType) {
        if (operatorType.equals("+")) {
            System.out.println("执行加法操作");
        } else if (operatorType.equals("-")) {
            System.out.println("执行减法操作");
        } else if (operatorType.equals("*")) {
            System.out.println("执行乘法操作");
        }
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.exec("+");
    }
}
