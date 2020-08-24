package com.pigcanfly.rpc.utils;

import com.pigcanfly.rpc.Reference;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tobbyquinn
 * @date 2020/04/15
 */
public class MetadataUtils {
    public static ConcurrentHashMap<String, String> findAllClassesByPackage(String pkg) {
        ConcurrentHashMap<String, String> metadata = new ConcurrentHashMap<>();
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Reference.class));
        Set<BeanDefinition> definitions = scanner.findCandidateComponents(pkg);

        for (BeanDefinition d : definitions) {

            String className = d.getBeanClassName();
            String packageName = className.substring(0, className.lastIndexOf('.'));
            //System.out.println("packageName:" + packageName + " , className:" + className);
            metadata.put(className, className);
        }
        return metadata;
    }

    /**
     * 获取当前类的接口，并不递归获取接口
     * @param fullClassName
     * @return
     */
    public static Class[] findInterfacesByClass(String fullClassName) {
        try {
            Class<?> aClass = Class.forName(fullClassName);
            return findInterfacesByClass(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取当前类的接口，并不递归获取接口
     * @param clazz
     * @return
     */
    public static Class[] findInterfacesByClass(Class clazz) {
        Class[] interfaces = clazz.getInterfaces();
        return interfaces;
    }
    private static void findAllInterfacesByClass(Class clazz) {
        //TODO: 递归获取类的接口
    }



    public static void main(String[] args) {
      //  MetadataUtils.findInterfacesByClass("")
    }
}
