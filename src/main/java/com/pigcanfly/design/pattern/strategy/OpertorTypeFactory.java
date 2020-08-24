package com.pigcanfly.design.pattern.strategy;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class OpertorTypeFactory {
    private OpertorTypeFactory() {
    }

    private static final HashMap<String, OperatorType> cache = new HashMap<String, OperatorType>();

    static {
        cache.put("+", new PlusOperator());
        cache.put("-", new SubOperator());
        cache.put("*", new MultiOperator());
    }

    public static OperatorType getOperator(String operType) {
        return cache.getOrDefault(operType, new NoneOperator());
    }
}
