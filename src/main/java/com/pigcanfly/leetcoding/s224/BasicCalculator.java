package com.pigcanfly.leetcoding.s224;

import java.util.Stack;

/**
 * @author Tobby Quinn
 * @date 2019/06/12
 */
public class BasicCalculator {
    private static Stack<Integer> dataStack = new Stack();
    private static Stack<Character> operatorStack = new Stack();

    public static int calculate(String s) {
        StringBuilder numbers = new StringBuilder();
        boolean continuesNum = false;
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            //空格直接跳出本次循环
            if (aChar == ' ') {
                continue;
            }
            if (aChar == '-' || aChar == '+' || aChar == '(' || aChar == ')' ) {
                if(continuesNum){
                    continuesNum=false;
                    dataStack.push(Integer.parseInt(numbers.toString()));
                    numbers=new StringBuilder();
                }

                //添加到操作栈
                if (aChar == ')') {
                    Character popOperator;
                    while ((popOperator = operatorStack.pop()) != '(') {
                        basicCaculate(popOperator);
                    }
                    continue;
                }
                if (operatorStack.isEmpty() || operatorStack.peek() == '(' || aChar == '(') {
                    operatorStack.push(aChar);
                } else {
                    Character popOperator1 = operatorStack.pop();
                    operatorStack.push(aChar);
                    basicCaculate(popOperator1);
                }

            } else {
                //其余数字添加到数据栈
                continuesNum=true;
                numbers.append(aChar);
            }

        }
        if(continuesNum){
            dataStack.push(Integer.parseInt(numbers.toString()));
        }
        if (!operatorStack.isEmpty()) {
            Character pop = operatorStack.pop();
            basicCaculate(pop);
        }

        return dataStack.pop();
    }


    private static void basicCaculate(Character popOperator) {
        int lastData = Integer.parseInt(dataStack.pop().toString());
        int firstData = Integer.parseInt(dataStack.pop().toString());
        if (popOperator == '+') {
            int tempResult = firstData + lastData;
            dataStack.push(tempResult);
        }
        if (popOperator == '-') {
            int tempResult = firstData - lastData;
            dataStack.push(tempResult);
        }
    }

    public static  int calculate1(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }


    public static void main(String[] args) {
        int calculate = calculate1("12+3-(1+4)");
        System.out.println(calculate);

    }
}
