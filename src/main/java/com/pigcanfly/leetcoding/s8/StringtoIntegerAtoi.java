package com.pigcanfly.leetcoding.s8;

/**
 * int atoi1(const char *str) {
 *         int sign = 1, base = 0, i = 0;
 *         while (str[i] == ' ') { i++; }
 *         if (str[i] == '-' || str[i] == '+') {
 *             sign = 1 - 2 * (str[i++] == '-');
 *         }
 *         while (str[i] >= '0' && str[i] <= '9') {
 *             if (base >  INT_MAX / 10 || (base == INT_MAX / 10 && str[i] - '0' > 7)) {
 *                 if (sign == 1) return INT_MAX;
 *                 else return INT_MIN;
 *             }
 *             base  = 10 * base + (str[i++] - '0');
 *         }
 *         return base * sign;
 *     }
 * @author tobbyquinn
 * @date 2019/10/31
 */
public class StringtoIntegerAtoi {
    public static int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (sb.length() == 0) {
                    continue;
                }
            }
            if (sb.length() == 0 && (c == '+' || c == '-')) {
                sb.append(c);
                continue;
            }
            if (!Character.isDigit(c)) {
                break;
            }
            sb.append(c);
        }
        if (sb.length() == 0 || (sb.length() == 1 && !Character.isDigit(sb.charAt(0)))) {
            return 0;
        }
        long res = 0L;
        char expectSymbol = ' ';
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                expectSymbol = c;
                continue;
            }
            res = res * 10 + Character.digit(c, 10);
            if (expectSymbol == '-') {
                if (-res < -2147483648) {
                    return -2147483648;
                }
            } else {
                if (res > 2147483647) {
                    return 2147483647;
                }
            }
        }
        return expectSymbol == '-' ? -(int) res : (int) res;
    }


    public static void main(String[] args) {
        int i = myAtoi(".1");
        System.out.println(i);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
