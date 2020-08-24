package com.pigcanfly.design.pattern.service;

import com.pigcanfly.design.pattern.entity.User;

/**
 * @author tobbyquinn
 * @date 2020/05/14
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public final String login(User user) {
        if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
            System.out.println("登录成功");
            return "Login Success";
        }
        return "Login Failed";
    }
}
