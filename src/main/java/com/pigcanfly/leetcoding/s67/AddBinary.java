package com.pigcanfly.leetcoding.s67;

/**
 * @author Tobby Quinn
 * @date 2019/06/14
 */
public class AddBinary {
    /**
     * 这是比较笨的一种方式，先将短位补齐0。。。。。。。。。。
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a, String b) {

        int diff = a.length() - b.length();
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                b = "0" + b;
            }
        }
        if (diff < 0) {
            for (int i = 0; i < -diff; i++) {
                a = "0" + a;
            }
        }
        int carryDigit = 0;
        StringBuilder res = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            int aChar = (int) (a.charAt(i) - '0');
            int bChar = (int) (b.charAt(i) - '0');
            int sum = aChar + bChar + carryDigit;
            if (sum > 1) {
                if (sum == 2) {
                    res.insert(0, 0);
                } else {

                    res.insert(0, 1);
                }
                carryDigit = 1;
            } else {
                res.insert(0, sum);
                carryDigit = 0;
            }

        }
        res = carryDigit == 1 ? res.insert(0, 1) : res;
        return res.toString();

    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carryDigit = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum=carryDigit;
            if(i>=0){
                sum+=a.charAt(i--)-'0';
            }
            if(j>=0){
                sum+=b.charAt(j--)-'0';
            }
            res.insert(0,sum%2);
            carryDigit=sum/2;
        }
        if(carryDigit==1){
            res.insert(0,1);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = addBinary("1010", "1011");
        System.out.println(s);
    }
}
