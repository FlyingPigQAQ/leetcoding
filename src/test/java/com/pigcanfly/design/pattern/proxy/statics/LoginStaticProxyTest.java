package com.pigcanfly.design.pattern.proxy.statics;

import com.pigcanfly.design.pattern.entity.User;
import com.pigcanfly.design.pattern.service.LoginServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tobbyquinn
 * @date 2020/05/14
 */
class LoginStaticProxyTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUserId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        LoginStaticProxy loginStaticProxy = new LoginStaticProxy(new LoginServiceImpl());
        loginStaticProxy.login(user);
    }

}