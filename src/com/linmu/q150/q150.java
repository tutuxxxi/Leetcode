package com.linmu.q150;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/20 11:16 上午
 * @description：
 * @modified By：
 * @version:
 */
public class q150 {
    public static void main(String[] args) {
        new Solution().evalRPN(new String[]{
                "4","13","5","/","+"
        });
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token : tokens){
            if(token.length() == 1 && "=-*/".contains(token)){
                int operator1 = Integer.valueOf(stack.pop());
                int operator2 = Integer.valueOf(stack.pop());

                switch (token){
                    case "+":
                        operator2 += operator1;
                        break;
                    case "-":
                        operator2 -= operator1;
                        break;
                    case "*":
                        operator2 *= operator1;
                        break;
                    case "/":
                        operator2 /= operator1;
                        break;
                }

                token = String.valueOf(operator2);
            }
            stack.push(token);
        }

        return Integer.valueOf(stack.pop());
    }
}
