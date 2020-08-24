package com.pigcanfly.rpc.server.serviceimpl;

import com.pigcanfly.rpc.GreetService;
import com.pigcanfly.rpc.Reference;

/**
 * @author tobbyquinn
 * @date 2020/04/14
 */
@Reference
public class GreetServiceImpl implements GreetService {
    @Override
    public String sayHello(String msg) {
        return "Hello "+msg;
    }
}
