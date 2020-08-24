package com.pigcanfly.leetcoding.s856;

import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2020/01/16
 */
public class ScoreofParentheses {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String c = String.valueOf(S.charAt(i));
            if(c.equals("(")){
                stack.push(c);
            }else if(c.equals(")")){
                String pop ;
                int sum=0;
                while(!(pop=stack.pop()).equals(String.valueOf('('))){
                    sum+=Integer.parseInt(pop);
                }
                sum=sum==0?1:sum*2;
                stack.push(String.valueOf(sum));
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            res+=Integer.parseInt(stack.pop());
        }
        return res;
    }

    public int scoreOfParentheses1(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }

    public int scoreOfParentheses2(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }

    public int scoreOfParentheses3(String S) {
        return F(S, 0, S.length());
    }

    public int F(String S, int i, int j) {
        //Score of balanced string S[i:j]
        int ans = 0, bal = 0;

        // Split string into primitives
        for (int k = i; k < j; ++k) {
            bal += S.charAt(k) == '(' ? 1 : -1;
            if (bal == 0) {
                if (k - i == 1) ans++;
                else ans += 2 * F(S, i+1, k);
                i = k+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int i = new ScoreofParentheses().scoreOfParentheses("()");
        System.out.println(i);
    }
}
