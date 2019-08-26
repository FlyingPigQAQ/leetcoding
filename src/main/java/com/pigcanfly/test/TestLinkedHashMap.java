package com.pigcanfly.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Tobby Quinn
 * @date 2019/08/19
 */
public class TestLinkedHashMap {

    public static void main(String[] args) {
        //删除最近最少使用需要开启：accessOrder:true, 重写removeEldestEntry()
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<String, Integer>(16, 0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) { //最大保存三个数
                return size()>3;
            }
        };

        cache.put("zhangsan",1);
        cache.keySet().stream().forEach(System.out::print);
        System.out.println();
        cache.put("wangwu",1);
        cache.keySet().stream().forEach(x-> System.out.print(x+","));
        System.out.println();
        cache.put("lisi",1);
        cache.keySet().stream().forEach(x-> System.out.print(x+","));
        System.out.println();
        cache.get("zhangsan");
        cache.put("zhaosi",1);
        cache.keySet().stream().forEach(x-> System.out.print(x+","));
        System.out.println();


    }
}
