package com.pigcanfly.design.pattern.service;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class ShipServiceImpl implements ShipService {
    @Override
    public String ship(String orderId) {
        System.out.println("开始邮寄");
        return "ShipId";
    }


}
