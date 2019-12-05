package com.pigcanfly.leetcoding.s925;

/**
 *
 * TODO : Two points
 * @author tobbyquinn
 * @date 2019/10/22
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if ("".equals(name) && "".equals(typed)) {
            return true;
        } else if ("".equals(name) || "".equals(typed)) {
            return false;
        } else if (typed.length() < name.length()) {
            return false;
        }
        char lastC = '0';
        for (int i = 0, j = 0; j < typed.length() || i < name.length(); j++) {
            if(j>=typed.length()&&i<name.length()){
                return false;
            }
            char typeC = typed.charAt(j);
            if (i < name.length()) {
                char nameC = name.charAt(i);
                if (typeC == nameC) {
                    lastC = typeC;
                    i++;
                    continue;
                }
            }
            if (typeC != lastC) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new LongPressedName().isLongPressedName("pyplrz",
                "ppyypllr");
    }
}
