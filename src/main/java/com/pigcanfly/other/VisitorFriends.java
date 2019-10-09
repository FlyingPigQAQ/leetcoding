package com.pigcanfly.other;

import java.util.Scanner;

/**
 * @author tobbyquinn
 * @date 2019/09/27
 */
public class VisitorFriends {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arg = sc.nextInt();
        int res = new VisitorFriends().count(arg);
        System.out.println(res);
    }

    public int count(int remainStep){
        if(remainStep<6){
            return 1;
        }
        return remainStep%5==0?remainStep/5:remainStep/5+1;
    }
}
