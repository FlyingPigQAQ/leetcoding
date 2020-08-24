package com.pigcanfly.design.pattern.strategy;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class MultiOperator implements OperatorType {
    @Override
    public void exec() {
        System.out.println("执行乘法操作");
    }
}
