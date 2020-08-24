package com.pigcanfly.design.pattern.service;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public String placeOrder() {
        System.out.println("下订单...");
        return "orderId";
    }
}
