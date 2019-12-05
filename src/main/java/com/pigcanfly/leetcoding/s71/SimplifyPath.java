package com.pigcanfly.leetcoding.s71;

import java.util.LinkedList;

/**
 * @author tobbyquinn
 * @date 2019/11/01
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "";
        }
        if (path.length() == 1 && path.charAt(0) == '/') {
            return "/";
        }
        String[] split = path.split("/+");
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i < split.length; i++) {
            String str = split[i];
            if ("..".equals(str) ) {
                if(!linkedList.isEmpty()){
                    linkedList.removeLast();
                }
            } else if(!".".equals(str)) {
                linkedList.addLast("/" + str);
            }
        }
        StringBuilder res = new StringBuilder();
        int len = linkedList.size();
        for (int i = 0; i < len; i++) {
            res.append(linkedList.pollFirst());
        }
        return res.length()==0?"/":res.toString();
    }

    public static void main(String[] args) {
        String[] split = "/a//b////c/d//././/../".split("/+");
        System.out.println(split);
        String s = new SimplifyPath().simplifyPath(
                "/a/./b/../../c/");
        System.out.println(s);
    }
}
