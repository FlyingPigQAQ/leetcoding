package com.pigcanfly.leetcoding;

import java.util.Scanner;

/**
 * @author Tobby Quinn
 * @date 2019/06/30
 */
public class MonkeyEat {
    public  static int eat(int[] args,int hours,int total){
        int k = total%hours==0?total/hours:total/hours+1;
        while (k<=total){
            int kHours=0;
            for (int i = 0; i < args.length; i++) {
                kHours+=args[i]%k==0?args[i]/k:args[i]/k+1;
            }
            if(kHours<=hours){
                return k;
            }

            k++;
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        String[] s = res.split("\\s");
        int[] argInts = new int[s.length-1];
        int specialHours = 0;
        int totals = 0;
        //校验输入格式是否正确
        for (int i = 0; i < s.length; i++) {
            try {
                if(i==s.length-1){
                    specialHours=Integer.valueOf(s[i]);
                }else {
                    argInts[i] = Integer.valueOf(s[i]);
                    totals+=argInts[i];
                }
            }catch (Exception e){
                System.out.println(-1);
                return;
            }
        }

        //如果返回时间小于蟠桃树，则直接返回-1
        if(argInts.length>specialHours){
            System.out.println(-1);
            return;
        }
        int miniK = eat(argInts, specialHours,totals);
        System.out.println(miniK);
    }
}
