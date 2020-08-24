package com.pigcanfly.design.pattern.service;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class PayServiceImpl implements PayService {
    @Override
    public boolean pay(String orderId) {
        System.out.println("支付成功...");
        return true;
    }
}
