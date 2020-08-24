package com.pigcanfly.design.pattern.facade;

import com.pigcanfly.design.pattern.service.ShipServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
class BuyServiceFacadeTest {

    BuyServiceFacade buyServiceFacade = new BuyServiceFacade();

    @Test
    void buy() {
        buyServiceFacade.buy();
    }
}