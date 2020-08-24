package com.pigcanfly.rpc.utils;

import com.pigcanfly.rpc.Reference;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ServiceLoader;
import java.util.function.Predicate;

import static javax.lang.model.util.ElementFilter.typesIn;

/**
 * @author tobbyquinn
 * @date 2020/04/15
 */
public class ReflectionUtils {
    public static void main(String[] args) {
        try {

            //  Object greetService = Class.forName("GreetService").newInstance();
            Method declaredMethod = Class.forName("com.pigcanfly.rpc.GreetService").getDeclaredMethod("sayHello",String.class);
            Object invoke = declaredMethod.invoke(Class.forName("com.pigcanfly.rpc.GreetService").newInstance(), "Netty");
            System.out.println((String)invoke);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
