package com.pigcanfly.design.pattern.proxy.statics;

import com.pigcanfly.design.pattern.entity.User;
import com.pigcanfly.design.pattern.service.LoginService;

/**
 * @author tobbyquinn
 * @date 2020/05/14
 */
public class LoginStaticProxy {

    private LoginService loginService=null;
    public LoginStaticProxy(LoginService loginService){
        this.loginService=loginService;
    }
    //TODO:异常捕捉
    public String login(User user){
        beforeMethod();
        String result = loginService.login(user);
        afterMethod();
        return result;
    }
    private void beforeMethod(){
        System.out.println("BeforeMethod Invoke");
    }
    private void afterMethod(){
        System.out.println("AfterMethod Invoke");
    }

}
