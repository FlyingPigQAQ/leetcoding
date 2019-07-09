package com.pigcanfly.leetcoding.s682;

import java.util.Stack;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        int result=0;
        if(ops.length==0){
            return result;
        }
        Stack<Integer> data = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("C")){
                Integer pop = data.pop();
                result-=pop;
                continue;
            }
            if(ops[i].equals("D")){
                //未做校验，有可能栈为空，一下出栈操作同理
                Integer peek = data.peek();
                data.push(peek*2);
                result+=(peek*2);
                continue;
            }
            if(ops[i].equals("+")){
                Integer firstPop = data.pop();
                Integer secondPop = data.pop();
                data.push(secondPop);
                data.push(firstPop);
                data.push(firstPop+secondPop);
                result+=(firstPop+secondPop);
                continue;
            }
            Integer num = Integer.valueOf(ops[i]);
            data.push(num);
            result+=num;
        }
        return result;

    }
}
