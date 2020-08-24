package com.pigcanfly.design.pattern.strategy;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class OperatorWithStrategy {
    public void exec(String operatorType) {
        OperatorType operator=OpertorTypeFactory.getOperator(operatorType);
        operator.exec();
    }

    public static void main(String[] args) {
        OperatorWithStrategy operator = new OperatorWithStrategy();
        operator.exec("+");
    }
}
