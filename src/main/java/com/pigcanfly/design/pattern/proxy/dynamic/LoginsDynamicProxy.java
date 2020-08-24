package com.pigcanfly.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tobbyquinn
 * @date 2020/05/14
 */
public class LoginsDynamicProxy implements InvocationHandler {
    private Object proxiedObject;
    public LoginsDynamicProxy(Object proxiedObject){
        this.proxiedObject=proxiedObject;
    }
    public Object bind(){
        Class<?> aClass = proxiedObject.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod();
        Object res = method.invoke(proxiedObject, args);
        afterMethod();
        return res;
    }

    private void beforeMethod(){
        System.out.println("BeforeMethod Invoke");
    }
    private void afterMethod(){
        System.out.println("AfterMethod Invoke");
    }
}
