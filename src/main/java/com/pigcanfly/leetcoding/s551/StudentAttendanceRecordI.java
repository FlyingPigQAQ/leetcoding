package com.pigcanfly.leetcoding.s551;

/**
 * @author tobbyquinn
 * @date 2019/10/18
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int a=0,l=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='A'){
                l=0;
                a++;
            }else if(c=='L'){
                l++;
            }else{
                l=0;
            }
            if(a>1 || l>2){
                return false;
            }
        }
        return true;
    }
}
