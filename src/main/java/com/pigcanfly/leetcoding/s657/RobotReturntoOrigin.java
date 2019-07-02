package com.pigcanfly.leetcoding.s657;

/**
 * @author Tobby Quinn
 * @date 2019/06/30
 */
public class RobotReturntoOrigin {

    public boolean judgeCircle(String moves) {
        int vertical=0,horizon=0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if(c=='U'){
                vertical++;
            }
            if(c=='D'){
                vertical--;
            }
            if(c=='L'){
                horizon--;
            }
            if(c=='R'){
                horizon++;
            }
        }
        return vertical==0 && horizon==0;

    }
}
