package com.pigcanfly.leetcoding.s393;

/**
 * @author tobbyquinn
 * @date 2019/10/12
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int conti = 0;
        for (int datum : data) {
            for (int i = 3, firstZero = 32; i < 8; i++) {
                if (((datum >> i) & 1) == 0) {
                    firstZero = Math.min(7 - i, firstZero);
                }
                if (i == 7) {
                    if (firstZero == 32) {
                        return false;
                    }
                    if (conti != 0) {
                        if (firstZero != 1) {
                            return false;
                        }
                        conti--;
                        break;
                    }
                    // 筛选掉 直接以10xx xxxx开头的
                    if (firstZero == 1) {
                        return false;
                    }
                    conti = firstZero == 0 ? 0 : firstZero - 1;
                }
            }
        }
        if (conti != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new UTF8Validation().validUtf8(new int[]{197, 130, 1});
        System.out.println(b); //true

        boolean c = new UTF8Validation().validUtf8(new int[]{10});
        System.out.println(c); //true

        boolean d = new UTF8Validation().validUtf8(new int[]{255});
        System.out.println(d); //false

    }
}
