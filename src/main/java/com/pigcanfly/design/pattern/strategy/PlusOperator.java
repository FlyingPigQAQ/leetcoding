package com.pigcanfly.design.pattern.strategy;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class PlusOperator implements OperatorType {
    @Override
    public void exec() {
        System.out.println("执行加法操作");
    }
}
