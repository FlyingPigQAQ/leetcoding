package com.pigcanfly.rpc.utils;

import com.sun.javafx.util.Logging;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2020/04/17
 */
public class ClassUtils {
    //TODO:完善
    public static ClassLoader getClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // cannnot access thread context classloader. fallback..

        }
        if (cl == null) {
            //No thread context classloader -> use this class classloader
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                try {
                    // getClassLoader() return null indicates SystemClassLoader
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {
                    //cannot getSystemClassloder Maybe caller can live with null
                }
            }
        }
        return cl;
    }

    public static void printClassLoader() {
        //applicationClassLoader
        System.out.println("ApplicationClassLoader: " + ClassUtils.class.getClassLoader());
        for (String s : System.getProperty("java.class.path").split(":")) {
            System.out.println(s);
        }
        //ExtensionClassLoader
        System.out.println("ExtensionClassLoader: " + Logging.class.getClassLoader());
        for (String s : System.getProperty("java.ext.dirs").split(":")) {
            System.out.println(s);
        }
        //BootstrapClassLoader
        System.out.println("BootstrapClassLoader(Display null): " + ArrayList.class.getClassLoader());
        for (String s : System.getProperty("sun.boot.class.path").split(":")) {
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        ClassUtils.printClassLoader();
        try {
            Thread.sleep(1000_1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
