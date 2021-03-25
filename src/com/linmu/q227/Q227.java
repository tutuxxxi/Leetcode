package com.linmu.q227;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/11 3:17 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q227 {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate("421241124"));;
    }
}

class Solution {
    public int calculate(String s) {
        if(s.length() == 1){
            return Integer.valueOf(s);
        }


        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int mark = 0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != ' '){
                if(chars[i] == '+' || chars[i] == '-'){
                    stack.push(Character.toString(chars[i]));
                }else if (chars[i] == '*' || chars[i] == '/'){
                    //下一步弹出计算
                    mark = chars[i] == '*' ? 1 : -1;
                }else{
                    //弹出的为数字,获取总数字
                    int temp = Integer.valueOf(Character.toString(chars[i]));
                    while(++i < chars.length && Character.isDigit(chars[i])){
                        temp = temp * 10 + (chars[i] - '0');
                    }
                    i--;

                    //此时temp为获得的数字
                    if(mark != 0){
                        int num = Integer.valueOf(stack.pop());
                        temp = mark == 1 ? num * temp : num / temp;
                        mark = 0;
                    }

                    stack.push(Integer.toString(temp));
                }
            }
        }

        //压栈完成，计算并返回值
        Stack<String> reverse = new Stack<>();
        while(!stack.isEmpty()){
            reverse.push(stack.pop());
        }

        return getRes(reverse);

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
