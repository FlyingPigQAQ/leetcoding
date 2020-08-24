package com.pigcanfly.leetcoding.s1256;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author tobbyquinn
 * @date 2020/07/20
 */
public class EncodeNumber {
    public String encode(int num) {
        return "0";
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.java.command"));
        String str ="0";
        for (int i = 0; i <1 ; i++) {
            if(i==0){
                System.out.println("\"\"");
                continue;
            }
            if(i==1){
                System.out.println("0");
                continue;
            }
            //增加
            StringBuilder sb = new StringBuilder();
            int ans=1,j=str.length()-1;
            while (j>=0 || ans==1){
                char c='8';
                if(j>=0){
                     c = str.charAt(j);
                }

                if(c=='0'){
                    if(ans==0){
                        sb.insert(0,'0');
                    }else{
                        sb.insert(0,'1');
                    }
                    ans=0;
                }else if(c=='1'){
                    if(ans==0){
                        sb.insert(0,'1');
                        ans=0;
                    }else{
                        sb.insert(0,'0');
                        ans=1;
                    }
                }else{
                    sb.insert(0,'0');
                    ans=0;
                }
                j--;
            }
            str=sb.toString();
            System.out.println(str);
        }
    }

}
