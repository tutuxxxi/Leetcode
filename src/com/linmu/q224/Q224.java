package com.linmu.q224;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/10 10:02 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q224 {
    public static void main(String[] args) {
        new Solution().calculate("(1+(4+5+2)-3)+(6+8)");
    }
}


class Solution {
    public int calculate(String s) {
        if(s.length() == 1){
            return Integer.valueOf(s);
        }


        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != ' '){
                if(chars[i] == '+' || chars[i] == '-' || chars[i] == '('){
                    stack.push(Character.toString(chars[i]));
                }else{

                    if(chars[i] == ')'){
                        //pop并计算 由于计算的优先级，需要按序计算
                        Stack<String> reverseStack = new Stack();

                        while(!stack.peek().equals("(")){
                            reverseStack.push(stack.pop());
                        }

                        stack.pop();
                        stack.push(Integer.toString(getRes(reverseStack)));

                    }else{
                        //计算数字并存入
                        int temp = i+1;
                        while(temp < chars.length && Character.isDigit(chars[temp])){
                            temp++;
                        }
                        temp--;

                        //从i到temp的位置均为数字
                        int num = 0;
                        for(; i<=temp; i++){
                            num = num * 10 + (chars[i] - '1' + 1);
                        }
                        i--;
                        stack.push(Integer.toString(num));
                    }
                }
            }
        }

        //此时stack中只存在一个计算式
        Stack<String> reverseStack = new Stack();
        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }

        return getRes(reverseStack);
    }


    private static int getRes(Stack<String> stack){
        int num = 0;
        int operator = 0;

        //此时应该计算reverseStack中的数据
        while (!stack.isEmpty()){
            String pop = stack.pop();

            if(pop.equals("-")){
                operator = -1;
            }else if( pop.equals("+")){
                operator = 1;
            }else{
                int getNum = Integer.valueOf(pop);

                if(operator == 0){
                    num = getNum;
                }else{
                    if(operator == -1){
                        num -= getNum;
                    }else{
                        num += getNum;
                    }
                }
            }
        }

        return num;
    }
}