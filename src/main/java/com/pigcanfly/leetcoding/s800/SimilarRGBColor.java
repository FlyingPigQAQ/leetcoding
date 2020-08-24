package com.pigcanfly.leetcoding.s800;

/**
 * @author tobbyquinn
 * @date 2020/05/11
 */
public class SimilarRGBColor {
    public String similarRGB(String color) {
        return "#"+getMinDiff1(color.substring(1,3))+getMinDiff1(color.substring(3,5))+getMinDiff1(color.substring(5));
    }
    String getMinDiff(String c){
        String[] arr ={"00","11","22","33","44","55","66","77",
                "88","99","aa","bb","cc","dd","ee","ff"};
        String min="ff";
        int cInt=Integer.parseInt(c,16);
        for (int i = 0; i < arr.length; i++) {
            if(Math.abs(Integer.parseInt(arr[i],16)-cInt)<Math.abs(Integer.parseInt(min,16)-cInt)){
                min=arr[i];
            }
        }
        return min;
    }

    String getMinDiff1(String c){
        // 都是17的倍数
//        String[] arr ={"00","11","22","33","44","55","66","77",
//                "88","99","aa","bb","cc","dd","ee","ff"};

        int cInt=Integer.parseInt(c,16);
        //cInt%17>8?1:0 结果为1 靠近后面的数值。 取模结果0,1,2...16
        int res = cInt/17+(cInt%17>8?1:0);
        return String.format("%02x",res*17);
    }


    public static void main(String[] args) {
        System.out.println(new SimilarRGBColor().similarRGB("#09f166"));
    }
}
