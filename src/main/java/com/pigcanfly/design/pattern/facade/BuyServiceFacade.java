package com.pigcanfly.design.pattern.facade;

import com.pigcanfly.design.pattern.service.*;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class BuyServiceFacade {
    private OrderService orderService = new OrderServiceImpl();
    private PayService payService = new PayServiceImpl();
    private ShipService shipService = new ShipServiceImpl();

    void buy(){
        String orderId = orderService.placeOrder();
        payService.pay(orderId);
        shipService.ship(orderId);
    }
}
