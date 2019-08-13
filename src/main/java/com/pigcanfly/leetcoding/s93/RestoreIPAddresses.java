package com.pigcanfly.leetcoding.s93;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tobby Quinn
 * @date 2019/07/27
 */
public class RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 15) {
            return Collections.emptyList();
        }
        LinkedList<String> res = new LinkedList<>();
        restoreIpAddresses(s, res, 1, "");
        return res;
    }

    public static void restoreIpAddresses(String s, LinkedList<String> res, int times, String sb) {
        if (times >= 5 && s.length() > 0) {
            return;
        }
        if (times == 5) {
            res.add(sb);
            return;
        }
        if (s.length() < 1) {
            return;
        }
        restoreIpAddresses(s.substring(1), res, times + 1, "".equals(sb) ? s.substring(0, 1) : sb + '.' + s.substring(0, 1));
        if (s.length() < 2  ||s.substring(0, 2).startsWith("0")) {
            return;
        }
        restoreIpAddresses(s.substring(2), res, times + 1, "".equals(sb) ? s.substring(0, 2) : sb + '.' + s.substring(0, 2));
        if (s.length() < 3 || s.substring(0, 3).startsWith("0") ||Integer.parseInt(s.substring(0, 3)) > 255) {
            return;
        }
        restoreIpAddresses(s.substring(3), res, times + 1, "".equals(sb) ? s.substring(0, 3) : sb + '.' + s.substring(0, 3));

    }

    //TODO: ++times 在迭代中为啥使用会有问题
    public static void main(String[] args) {
       // System.out.println("12".substring(0,2));
        List<String> strings = restoreIpAddresses("010010");
        System.out.println(strings.size());

    }
}
