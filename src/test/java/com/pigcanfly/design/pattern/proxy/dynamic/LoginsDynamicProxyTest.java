package com.pigcanfly.design.pattern.proxy.dynamic;

import com.pigcanfly.design.pattern.entity.User;
import com.pigcanfly.design.pattern.proxy.statics.LoginStaticProxy;
import com.pigcanfly.design.pattern.service.LoginService;
import com.pigcanfly.design.pattern.service.LoginServiceImpl;


/**
 * @author tobbyquinn
 * @date 2020/05/14
 */
class LoginsDynamicProxyTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUserId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        LoginService loginDynamicProxy = (LoginService) new LoginsDynamicProxy(new LoginServiceImpl()).bind();
        loginDynamicProxy.login(user);
    }

}