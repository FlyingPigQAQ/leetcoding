package com.pigcanfly.leetcoding.s405;

/**
 * @author tobbyquinn
 * @date 2020/02/12
 */
public class ConvertaNumbertoHexadecimal {
    public String toHex1(int num) {
        if (num == 0) {
            return "0";
        }
        long numl = num;
        if (numl < 0) {
            numl += Math.pow(2, 32);
        }
        StringBuilder sb = new StringBuilder();
        while (numl != 0) {
            long mod = numl % 16;
            if (mod < 10) {
                sb.insert(0, mod);
            } else {
                sb.insert(0, (char) ('a' + (mod - 10)));
            }
            numl /= 16;
        }
        return sb.toString();
    }

    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        char[] dict = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res="";
        while (num!=0){
            res=dict[num&15]+res;
            num>>>=4;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ConvertaNumbertoHexadecimal().toHex(-1));
    }
}
